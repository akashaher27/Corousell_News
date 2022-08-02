package com.example.corousellnews.data.news.repo

import com.example.corousellnews.data.news.model.NewsDataModel
import com.example.corousellnews.data.news.model.toNewsDataModel
import com.example.corousellnews.data.news.remote.NewsApi
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class NewsRepoImp @Inject constructor(private val newsApi: NewsApi) : NewsRepo {

    override fun getNewasArticle(): Flowable<NewsDataModel> {
        return newsApi.getNewsArticles().map {
            it.toNewsDataModel()
        }
    }
}