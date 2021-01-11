package com.clean.presentation.model

import com.clean.common.CURRENCY
import com.clean.common.Utils
import com.clean.common.WEIGTH
import com.clean.presentation.model.base.BasePresentationModel

data class Product(
    val id: String,
    val name: String?,
    val photo: Photo?,
    val price: Long?,
    val rating: Rating?,
    val vendor: Vendor?,
    val weight: Float?
) : BasePresentationModel {

    val weightTitle: String
        get() = "$weight $WEIGTH"

    val priceTitle: String
        get() = "${Utils.priceFormatter(price)} $CURRENCY"
}


data class Photo(
    val url: String?
)

data class Rating(
    val count: Int?,
    val rating: Float?
) {
    val ratingTitle: String
        get() = "($count) $rating "
}

data class Vendor(
    val name: String?
)