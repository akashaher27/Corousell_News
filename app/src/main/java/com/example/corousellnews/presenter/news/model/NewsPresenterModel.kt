package com.example.corousellnews.presenter.news.model

import com.example.corousellnews.data.news.model.NewsArticle
import com.example.corousellnews.presenter.news.view.ArticleModel

data class NewsPresenterModel(
    var articleList: MutableList<ArticleModel>?
)
