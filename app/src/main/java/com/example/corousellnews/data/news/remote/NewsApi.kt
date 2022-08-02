package com.example.corousellnews.data.news.remote

import com.example.corousellnews.data.news.model.NewsArticle
import com.example.corousellnews.data.news.model.NewsRemoteModel
import io.reactivex.rxjava3.core.Flowable

interface NewsApi {

    fun getNewsArticles(): Flowable<NewsRemoteModel>
}