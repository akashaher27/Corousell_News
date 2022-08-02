package com.example.corousellnews.app.hilt

import com.example.corousellnews.app.retrofit.Retrofit
import com.example.practiceproject.app.remote.retrofit.OkhttpNetClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): retrofit2.Retrofit {
        return Retrofit.getClient(okHttpClient)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkhttpNetClient().getClient()
    }
}