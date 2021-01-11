package com.clean.data.utils

import com.clean.data.dataSourse.api.response.ApiBaseResponse

class GeneralError constructor(
    var throwable: Throwable? = null,
    var message: String? = null,
    var response: ApiBaseResponse? = null,
    var errorType: ErrorType? = null,
)

fun GeneralError.withError(
    errorType: ErrorType,
    throwable: Throwable? = null,
    message: String? = null,
    baseResponse: ApiBaseResponse? = null
): GeneralError {
    this.errorType = errorType
    this.throwable = throwable
    this.message = message
    this.response = baseResponse

    baseResponse?.let {
        it.errors?.let { errs ->
            if (errs.isNotEmpty())
                this.message = errs[0].message
        }
    }

    return GeneralError(throwable = this.throwable, message = this.message, response = this.response, errorType = this.errorType)
}

sealed class ErrorType {
    object ResponseError : ErrorType()
    object UnAuthorizedError : ErrorType()
    object TimeOutError : ErrorType()
    object NetworkError : ErrorType()
    object UnknownError : ErrorType()
}