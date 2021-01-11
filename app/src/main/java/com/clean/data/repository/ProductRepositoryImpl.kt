package com.clean.data.repository


import com.clean.data.dataSourse.api.ApiInterface
import com.clean.data.repository.base.LocalBoundRepository
import com.clean.data.dataSourse.api.response.ApiSingleResponse
import com.clean.data.dataSourse.local.dao.ProductDao
import com.clean.data.mapper.ProductEntityToDomainModelMapper
import com.clean.data.models.response.ProductSearchResponse
import com.clean.data.utils.ResponseResult
import com.clean.data.utils.getResponse
import com.clean.domain.model.ProductDomainModel
import com.clean.domain.model.output.ProductSearchOut
import com.clean.domain.repository.ProductRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
class ProductRepositoryImpl @Inject constructor(
    private val postsDao: ProductDao,
    private val apiInterface: ApiInterface
) : ProductRepository {

    override suspend fun getProducts(query: ProductSearchOut): Flow<ResponseResult<List<ProductDomainModel>>> {
        return object : LocalBoundRepository<List<ProductDomainModel>, ApiSingleResponse<ProductSearchResponse>>() {

            override suspend fun saveRemoteData(response: ApiSingleResponse<ProductSearchResponse>) =
                postsDao.insertPosts(
                    response.data.productSearch.products
                )

            override fun fetchFromLocal(): Flow<List<ProductDomainModel>> =
                postsDao.getAllPosts().map { list ->
                    list.map { entity ->
                        ProductEntityToDomainModelMapper.toDomainModel(entity)
                    }
                }

            override suspend fun fetchFromRemote(): ApiSingleResponse<ProductSearchResponse> =
                apiInterface.getProductList(query).getResponse()

        }.getFlow().flowOn(Dispatchers.IO)

    }
}