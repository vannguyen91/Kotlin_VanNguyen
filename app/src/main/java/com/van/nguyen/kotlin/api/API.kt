package com.van.nguyen.kotlin.api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object API {
    private var retrofit: Retrofit? = null
    val apiService: APIService
        get() {
            if (retrofit == null) {
                val httpClient = OkHttpClient.Builder()
                httpClient.connectTimeout(3, TimeUnit.MINUTES)
                httpClient.readTimeout(3, TimeUnit.MINUTES)
                httpClient.writeTimeout(3, TimeUnit.MINUTES)
                httpClient.addInterceptor { chain ->
                    val original = chain.request()
                    val request: Request =
                        original.newBuilder()
                            .method(original.method(), original.body())
                            .build()
                    val response = chain.proceed(request)
                    response
                }
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                httpClient.interceptors().add(logging)
                val client = httpClient.build()
                retrofit = Retrofit.Builder()
                    .baseUrl("http://grand-qa-env-cloned.us-east-2.elasticbeanstalk.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return retrofit!!.create(APIService::class.java)
        }
}
