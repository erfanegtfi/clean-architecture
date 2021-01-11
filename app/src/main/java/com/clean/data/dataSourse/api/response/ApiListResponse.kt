package com.clean.data.dataSourse.api.response;

import com.google.gson.annotations.SerializedName;


class ApiListResponse<T>(
    @SerializedName("result") var data: MutableList<T>
) : ApiBaseResponse() {


}