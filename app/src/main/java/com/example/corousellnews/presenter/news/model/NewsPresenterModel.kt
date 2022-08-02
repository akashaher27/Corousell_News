package com.example.corousellnews.presenter.news.model

import com.example.corousellnews.data.news.model.NewsArticle

data class NewsPresenterModel(
    var articleList: MutableList<NewsArticle>?
)
