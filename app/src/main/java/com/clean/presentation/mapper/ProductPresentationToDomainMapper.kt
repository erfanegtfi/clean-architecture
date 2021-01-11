package com.clean.presentation.mapper

import com.clean.presentation.mapper.base.PresentationLayerMapper
import com.clean.domain.model.PhotoDomainModel
import com.clean.domain.model.ProductDomainModel
import com.clean.domain.model.RatingDomainModel
import com.clean.domain.model.VendorDomainModel
import com.clean.presentation.model.Photo
import com.clean.presentation.model.Product
import com.clean.presentation.model.Rating
import com.clean.presentation.model.Vendor

object ProductPresentationToDomainMapper : PresentationLayerMapper<ProductDomainModel, Product> {

    override fun toPresenterModel(e: ProductDomainModel): Product {
        return Product(
            id = e.id,
            name = e.name,
            photo = Photo(url = e.photo?.url),
            price = e.price,
            rating = Rating(count = e.rating?.count, rating = e.rating?.rating),
            vendor = Vendor(name = e.vendor?.name),
            weight = e.weight
        )
    }

    override fun toDomain(d: Product): ProductDomainModel {
        return ProductDomainModel(
            id = d.id,
            name = d.name,
            photo = PhotoDomainModel(url = d.photo?.url),
            price = d.price,
            rating = RatingDomainModel(count = d.rating?.count, rating = d.rating?.rating),
            vendor = VendorDomainModel(name = d.vendor?.name),
            weight = d.weight
        )
    }

}

//object ProductSearchPresentationToDomainMapper : PresentationLayerMapper<ProductSearchOutDomainModel, ProductSearchOut> {
//    override fun toPresenterModel(e: ProductSearchOutDomainModel): ProductSearchOut {
//        return ProductSearchOut(
//            query = e.query,
//        )
//    }
//
//    override fun toDomain(d: ProductSearchOut): ProductSearchOutDomainModel {
//        return ProductSearchOutDomainModel(
//            query = d.query,
//        )
//    }
//}