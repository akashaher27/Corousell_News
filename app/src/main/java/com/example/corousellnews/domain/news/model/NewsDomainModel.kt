package com.example.corousellnews.domain.news.model

import com.example.corousellnews.data.news.model.NewsArticle
import com.example.corousellnews.presenter.news.model.NewsPresenterModel

data class NewsDomainModel(
    var articleList: MutableList<NewsArticle>?
)

fun NewsDomainModel.toNewsPresenterModel(): NewsPresenterModel = NewsPresenterModel(this.articleList)
