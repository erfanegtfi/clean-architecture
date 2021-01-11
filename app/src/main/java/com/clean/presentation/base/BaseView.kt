package com.clean.presentation.base;

import com.clean.data.dataSourse.api.response.ApiBaseResponse
import com.clean.data.utils.GeneralError


interface BaseView {

    fun showLoading(message: String?)

    fun showLoading()

    fun hideLoading()

    fun unauthorizedUser(response: ApiBaseResponse?)

    fun onTimeout(throwable: Throwable?)

    fun onNetworkError(throwable: Throwable?)

    fun onError(error: GeneralError?)

    fun onResponseMessage(message: ApiBaseResponse?)

}