package com.example.corousellnews.Data.news.remote

import com.example.corousellnews.Data.news.model.NewsRemoteModel
import retrofit2.Retrofit


class NewsApiImp(private val retrofit: Retrofit) : NewsApi {

    override fun getNewsArticles(): List<NewsRemoteModel> {
        return retrofit.create(NewsService::class.java).getNewsArticles()
    }

}