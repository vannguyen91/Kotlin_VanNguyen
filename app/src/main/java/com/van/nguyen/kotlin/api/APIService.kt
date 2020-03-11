package com.example.duong.appnews.Service

import com.van.nguyen.kotlin.model.BaseResponse
import com.van.nguyen.kotlin.model.RegisterResponse
import com.van.nguyen.kotlin.model.RequestRegisterAccount
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("api/v1/auth/authenticate")
    fun login(@Body request: RequestRegisterAccount?): Call<BaseResponse<RegisterResponse?>?>?
}
