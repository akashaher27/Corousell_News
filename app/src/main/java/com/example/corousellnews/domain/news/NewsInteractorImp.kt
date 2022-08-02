package com.example.corousellnews.domain.news

import com.example.corousellnews.data.news.model.toNewsDomainModel
import com.example.corousellnews.data.news.repo.NewsRepo
import com.example.corousellnews.domain.news.model.NewsDomainModel
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class NewsInteractorImp @Inject constructor(val newsRepo: NewsRepo) : NewsInteractor {
    override fun getNewsArticle():Flowable<NewsDomainModel> {
        return newsRepo.getNewasArticle().map {it.toNewsDomainModel()}
    }
}