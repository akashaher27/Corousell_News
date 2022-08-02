package com.example.corousellnews.data.news.remote

import com.example.corousellnews.data.news.model.NewsArticle
import com.example.corousellnews.data.news.model.NewsRemoteModel
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface NewsService {

    @GET("carousell-interview-assets/android/carousell_news.json")
    fun getNewsArticles(): Flowable<List<NewsArticle>>
}