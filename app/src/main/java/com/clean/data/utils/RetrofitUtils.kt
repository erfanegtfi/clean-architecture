package com.clean.data.utils

import com.clean.data.dataSourse.api.response.ApiBaseResponse
import retrofit2.Response

/**
 * Retrofit only gives generic response body when status is Successful.
 * This extension will also parse error body and will give generic response.
 */
fun <T: ApiBaseResponse> Response<T>.getResponse(): T {
    val responseBody = body()
    return if (this.isSuccessful && responseBody != null) {
        responseBody
    } else {
        val res = UtilsError<T>().parseError<T>(errorBody())!!
        res.httpCode = code()
        res
//        fromJson<T>(errorBody()!!.string())!!
    }
}
