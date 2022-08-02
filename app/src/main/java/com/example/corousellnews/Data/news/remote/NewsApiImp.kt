package com.example.corousellnews.Data.news.remote

import com.example.corousellnews.Data.news.model.NewsRemoteModel
import retrofit2.Retrofit
import javax.inject.Inject


class NewsApiImp @Inject constructor(private val retrofit: Retrofit) : NewsApi {

    override fun getNewsArticles(): List<NewsRemoteModel> {
        return retrofit.create(NewsService::class.java).getNewsArticles()
    }

}