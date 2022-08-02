package com.example.corousellnews.Data.news.remote

import com.example.corousellnews.Data.news.model.NewsRemoteModel
import retrofit2.http.GET

interface NewsService {

    @GET("carousell-interview-assets/android/carousell_news.json")
    fun getNewsArticles(): List<NewsRemoteModel>
}