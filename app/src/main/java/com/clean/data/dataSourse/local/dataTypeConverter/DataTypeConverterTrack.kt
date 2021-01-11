package com.clean.data.dataSourse.local.dataTypeConverter

import androidx.room.TypeConverter
import com.clean.data.models.PhotoEntity
import com.clean.data.models.RatingEntity
import com.clean.data.models.VendorEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataTypeConverterTrack {

    @TypeConverter
    fun fromPhoto(tracks: PhotoEntity): String {
        val type = object : TypeToken<PhotoEntity>() {}.type
        return Gson().toJson(tracks, type)
    }

    @TypeConverter
    fun toPhoto(track: String): PhotoEntity {
        val type = object : TypeToken<PhotoEntity>() {}.type
        return Gson().fromJson<PhotoEntity>(track, type)
    }


    @TypeConverter
    fun fromRating(tracks: RatingEntity): String {
        val type = object : TypeToken<RatingEntity>() {}.type
        return Gson().toJson(tracks, type)
    }

    @TypeConverter
    fun toRating(track: String): RatingEntity {
        val type = object : TypeToken<RatingEntity>() {}.type
        return Gson().fromJson<RatingEntity>(track, type)
    }


    @TypeConverter
    fun fromVendor(tracks: VendorEntity): String {
        val type = object : TypeToken<VendorEntity>() {}.type
        return Gson().toJson(tracks, type)
    }

    @TypeConverter
    fun toVendor(track: String): VendorEntity {
        val type = object : TypeToken<VendorEntity>() {}.type
        return Gson().fromJson<VendorEntity>(track, type)
    }

}