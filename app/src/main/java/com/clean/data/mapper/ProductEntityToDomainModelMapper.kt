package com.clean.data.mapper

import com.clean.data.mapper.base.DataLayerMapper
import com.clean.data.models.PhotoEntity
import com.clean.data.models.ProductEntity
import com.clean.data.models.RatingEntity
import com.clean.data.models.VendorEntity
import com.clean.data.models.output.ProductSearchOutEntity
import com.clean.domain.model.PhotoDomainModel
import com.clean.domain.model.ProductDomainModel
import com.clean.domain.model.RatingDomainModel
import com.clean.domain.model.VendorDomainModel
import com.clean.domain.model.output.ProductSearchOut

object ProductEntityToDomainModelMapper : DataLayerMapper<ProductEntity, ProductDomainModel> {
    override fun toDomainModel(e: ProductEntity): ProductDomainModel {
       return ProductDomainModel(
            id = e.id,
            name = e.name,
            photo = PhotoDomainModel(url = e.photo?.url),
            price = e.price,
            rating = RatingDomainModel(count = e.rating?.count, rating = e.rating?.rating),
            vendor = VendorDomainModel(name = e.vendor?.name),
            weight = e.weight
        )
    }

    override fun toEntity(d: ProductDomainModel): ProductEntity {
        return ProductEntity(
            id = d.id,
            name = d.name,
            photo = PhotoEntity(url = d.photo?.url),
            price = d.price,
            rating = RatingEntity(count = d.rating?.count, rating = d.rating?.rating),
            vendor = VendorEntity(name = d.vendor?.name),
            weight = d.weight
        )
    }
}

object ProductSearchEntityToDomainModelMapper : DataLayerMapper<ProductSearchOutEntity, ProductSearchOut> {
    override fun toDomainModel(e: ProductSearchOutEntity): ProductSearchOut {
        return ProductSearchOut(
            query = e.query,
        )
    }

    override fun toEntity(d: ProductSearchOut): ProductSearchOutEntity {
        return ProductSearchOutEntity(
            query = d.query,
        )
    }
}