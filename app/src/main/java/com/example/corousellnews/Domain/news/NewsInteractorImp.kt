package com.example.corousellnews.Domain.news

import com.example.corousellnews.Data.news.model.toNewsDomainModel
import com.example.corousellnews.Data.news.repo.NewsRepo
import com.example.corousellnews.Domain.news.model.NewsDomainModel
import javax.inject.Inject

class NewsInteractorImp @Inject constructor(val newsRepo: NewsRepo) : NewsInteractor {
    override fun getNewsArticle(): List<NewsDomainModel> {
        return newsRepo.getNewasArticle().map {
            it.toNewsDomainModel()
        }
    }
}