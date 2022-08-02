package com.example.corousellnews.Domain.news

import com.example.corousellnews.Domain.news.model.NewsDomainModel

interface NewsInteractor {

    fun getNewsArticle():List<NewsDomainModel>
}