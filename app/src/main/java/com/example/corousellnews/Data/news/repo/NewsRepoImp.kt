package com.example.corousellnews.Data.news.repo

import com.example.corousellnews.Data.news.model.NewsDataModel
import com.example.corousellnews.Data.news.model.NewsRemoteModel
import com.example.corousellnews.Data.news.model.toNewsDataModel
import com.example.corousellnews.Data.news.remote.NewsApi
import com.example.corousellnews.Data.news.remote.NewsService
import javax.inject.Inject

class NewsRepoImp @Inject constructor(private val newsApi: NewsApi) : NewsRepo {

    override fun getNewasArticle(): List<NewsDataModel> {
        return newsApi.getNewsArticles().map {
            it.toNewsDataModel()
        }
    }
}