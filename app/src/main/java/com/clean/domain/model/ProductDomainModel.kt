package com.clean.domain.model

import com.clean.domain.model.base.BaseDomainModel


data class ProductDomainModel(
    val id: String,
    val name: String?,
    val photo: PhotoDomainModel?,
    val price: Long?,
    val rating: RatingDomainModel?,
    val vendor: VendorDomainModel?,
    val weight: Float?
): BaseDomainModel

data class PhotoDomainModel(
    val url: String?
): BaseDomainModel

data class RatingDomainModel(
    val count: Int?,
    val rating: Float?
): BaseDomainModel

data class VendorDomainModel(
    val name: String?
): BaseDomainModel