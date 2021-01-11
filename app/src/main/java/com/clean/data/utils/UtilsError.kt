package com.clean.data.utils

import com.clean.data.dataSourse.api.response.ApiBaseResponse
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class UtilsError<T> {

    fun <T : ApiBaseResponse> parseError(responseBody: ResponseBody?): T? {
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).build()
        val converter = retrofit.responseBodyConverter<T>(
            ApiBaseResponse::class.java, arrayOfNulls(0)
        )

        var error: T? = null
        try {
            error = converter.convert(responseBody ?: ResponseBody.create(null, ""))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return error
    }
}