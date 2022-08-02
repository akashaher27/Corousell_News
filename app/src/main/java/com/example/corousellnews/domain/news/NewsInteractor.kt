package com.example.corousellnews.domain.news

import com.example.corousellnews.domain.news.model.NewsDomainModel
import io.reactivex.rxjava3.core.Flowable

interface NewsInteractor {

    fun getNewsArticle(): Flowable<NewsDomainModel>
}