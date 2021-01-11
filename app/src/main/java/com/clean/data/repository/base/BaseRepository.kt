package com.clean.data.repository.base

import android.util.Log
import com.clean.data.dataSourse.api.response.ApiBaseResponse
import com.clean.data.utils.*
import okhttp3.ResponseBody
import java.net.SocketTimeoutException

abstract class BaseRepository {

     fun <T> errorResponse(throwable: Throwable): ResponseResult<T> {
        val apiCallResult: ResponseResult<T>

         if (throwable is SocketTimeoutException) {
            apiCallResult = ResponseResult.Error(GeneralError().withError(throwable = throwable, errorType = ErrorType.TimeOutError))
        } else if (throwable is NoConnectivityException) {//|| throwable instanceof IOException
            apiCallResult = ResponseResult.Error(GeneralError().withError(throwable = throwable, errorType = ErrorType.NetworkError))
        } else {
            apiCallResult = ResponseResult.Error(GeneralError().withError(throwable = throwable, errorType = ErrorType.UnknownError))
             throwable.message?.let { Log.e("errorrrrrr ", it) };
        }

        return apiCallResult
    }

     fun <T> unSuccessResponse(responseBody: ResponseBody?, code: Int): ResponseResult<T> {
         val apiCallResult: ResponseResult<T>
         val baseResponse: ApiBaseResponse? = UtilsError<ApiBaseResponse>().parseError(responseBody)

         apiCallResult = if (code == 403 || code == 401)
             ResponseResult.Error(GeneralError().withError(baseResponse = baseResponse, errorType = ErrorType.UnAuthorizedError))
         else if (code == 404 || code == 500)
             ResponseResult.Error(GeneralError().withError(baseResponse = baseResponse, errorType = ErrorType.UnknownError))
         else {
             ResponseResult.Error(GeneralError().withError(baseResponse = baseResponse,  errorType = ErrorType.ResponseError))
         }

        return apiCallResult
    }

    //merge unSuccessResponse and onResponse
    fun <T> unSuccessResponse2(response: ApiBaseResponse): ResponseResult<T> {
        val apiCallResult: ResponseResult<T>
        val code: Int? = response.httpCode
        apiCallResult = if (code == 403 || code == 401)
            ResponseResult.Error(GeneralError().withError(baseResponse = response, errorType = ErrorType.UnAuthorizedError))
        else if (code == 404 || code == 500)
            ResponseResult.Error(GeneralError().withError(baseResponse = response, errorType = ErrorType.UnknownError))
        else {
            ResponseResult.Error(GeneralError().withError(baseResponse = response,  errorType = ErrorType.ResponseError))
        }

        return apiCallResult

    }

    //code 200 but success=false
    fun <T> onErrorResponse(response: ApiBaseResponse): ResponseResult<T> {

        val apiCallResult: ResponseResult<T>

        apiCallResult = ResponseResult.Error(GeneralError().withError(baseResponse = response, errorType = ErrorType.ResponseError))

        return apiCallResult
    }


}