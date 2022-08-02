package com.example.practiceproject.app.remote.retrofit

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkhttpNetClient() : OkHttpClient() {

    fun getClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor())
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}