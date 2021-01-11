package com.clean.data.dataSourse.api.response;

import com.clean.data.utils.ErrorApp
import com.google.gson.annotations.SerializedName;

open class ApiBaseResponse(
    @SerializedName("errors") var errors: List<ErrorApp>? = null,
//    @SerializedName("message") var msg: String? = null,
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("http_code") var httpCode: Int? = null,
) {
}
