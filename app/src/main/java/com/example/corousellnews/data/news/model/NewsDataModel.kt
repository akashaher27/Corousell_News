package com.example.corousellnews.data.news.model

import com.example.corousellnews.domain.news.model.NewsDomainModel

data class NewsDataModel(
    var articleList: MutableList<NewsArticle>?
)

fun NewsDataModel.toNewsDomainModel(): NewsDomainModel = NewsDomainModel(this.articleList)
