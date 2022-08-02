package com.example.corousellnews.Data.news.repo

import com.example.corousellnews.Data.news.model.NewsRemoteModel
import com.example.corousellnews.Data.news.remote.NewsApi
import com.example.corousellnews.Data.news.remote.NewsService

class NewsRepoImp(private val newsApi: NewsApi) : NewsRepo {

    override fun getNewasArticle(): List<NewsRemoteModel> {
        return newsApi.getNewsArticles()
    }
}