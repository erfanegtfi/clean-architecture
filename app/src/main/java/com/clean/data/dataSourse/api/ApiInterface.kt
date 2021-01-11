package com.clean.data.dataSourse.api;

import com.clean.data.dataSourse.api.response.ApiSingleResponse
import com.clean.data.models.response.ProductSearchResponse
import com.clean.domain.model.output.ProductSearchOut
import retrofit2.Response
import retrofit2.http.*


interface ApiInterface {

    @POST("user")
    suspend fun getProductList(@Body query: ProductSearchOut): Response<ApiSingleResponse<ProductSearchResponse>>

}
