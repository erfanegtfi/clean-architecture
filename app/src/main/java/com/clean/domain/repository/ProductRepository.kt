package com.clean.domain.repository

import com.clean.data.utils.ResponseResult
import com.clean.domain.model.ProductDomainModel
import com.clean.domain.model.output.ProductSearchOut
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProducts(query: ProductSearchOut): Flow<ResponseResult<List<ProductDomainModel>>>
}