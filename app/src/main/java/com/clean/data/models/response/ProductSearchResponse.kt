package com.clean.data.models.response;

import com.clean.data.models.ProductEntity
import com.google.gson.annotations.SerializedName
import java.util.*

data class ProductSearchResponse(

    @SerializedName("productSearch")
    var productSearch:  ProductListSearchResponse

)

data class ProductListSearchResponse(

    @SerializedName("products")
    var products:  List<ProductEntity> = ArrayList()

)