package com.clean.data.utils

sealed class ResponseResult<out T> {

//    object Initial : ResponseResult<Nothing>()
    object Loading : ResponseResult<Nothing>()
    data class Success<T>(val response: T) : ResponseResult<T>()
    data class Error(val error: GeneralError) : ResponseResult<Nothing>()

    companion object {


    }

}