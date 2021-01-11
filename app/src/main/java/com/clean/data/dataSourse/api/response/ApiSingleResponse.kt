package com.clean.data.dataSourse.api.response;


import com.google.gson.annotations.SerializedName;


class ApiSingleResponse<T>(
    @SerializedName("data") var data: T
) : ApiBaseResponse() {


}
