package com.clean.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.clean.data.dataSourse.local.dataTypeConverter.DataTypeConverterTrack
import com.clean.data.models.ProductEntity.Companion.TABLE_NAME
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_NAME)
@TypeConverters(DataTypeConverterTrack::class)
data class ProductEntity (
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String?,
    @SerializedName("photo")
    val photo: PhotoEntity?,
    @SerializedName("price")
    val price: Long?,
    @SerializedName("rating")
    val rating: RatingEntity?,
    @SerializedName("vendor")
    val vendor: VendorEntity?,
    @SerializedName("weight")
    val weight: Float?
): BaseEntity{

    companion object {
        const val TABLE_NAME = "product_list"
    }

}

data class PhotoEntity(
    @SerializedName("url")
    val url: String?
): BaseEntity

data class RatingEntity(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("rating")
    val rating: Float?
): BaseEntity

data class VendorEntity(
    @SerializedName("name")
    val name: String?
): BaseEntity