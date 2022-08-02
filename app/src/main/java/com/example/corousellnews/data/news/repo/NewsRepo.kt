package com.example.corousellnews.data.news.repo

import com.example.corousellnews.data.news.model.NewsDataModel
import io.reactivex.rxjava3.core.Flowable

interface NewsRepo {

    fun getNewasArticle(): Flowable<NewsDataModel>
}