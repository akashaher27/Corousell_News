package com.example.corousellnews.data.news.remote

import com.example.corousellnews.data.news.model.NewsArticle
import com.example.corousellnews.data.news.model.NewsRemoteModel
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Retrofit
import javax.inject.Inject


class NewsApiImp @Inject constructor(private val retrofit: Retrofit) : NewsApi {

    override fun getNewsArticles(): Flowable<NewsRemoteModel> {
        return retrofit.create(NewsService::class.java).getNewsArticles().map {
                NewsRemoteModel(it.toMutableList())
        }
    }

}
