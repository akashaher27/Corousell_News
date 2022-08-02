package com.example.corousellnews.Data.news.remote

import com.example.corousellnews.Data.news.model.NewsRemoteModel

interface NewsApi {

    fun getNewsArticles(): List<NewsRemoteModel>
}