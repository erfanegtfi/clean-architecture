package com.clean.domain.usecase

import com.clean.data.utils.ResponseResult
import com.clean.domain.model.ProductDomainModel
import com.clean.domain.model.output.ProductSearchOut
import com.clean.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductListUseCase @Inject constructor(private val productRepository: ProductRepository) {


//    suspend fun execute(query: ProductSearchOut): ResponseResult<List<ProductDomainModel>> {
//        var  result: ResponseResult<List<ProductDomainModel>> = ResponseResult.Loading
//
//        productRepository.getProducts(query).onStart {
//             result = ResponseResult.Loading
//        }.collect {
//            result = it
//        }
//
//        return result
//    }

    suspend fun execute(query: ProductSearchOut): Flow<ResponseResult<List<ProductDomainModel>>> {

        return productRepository.getProducts(query)

    }
}