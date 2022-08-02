package com.example.corousellnews.data.news.model

data class NewsRemoteModel(
    var articleList: MutableList<NewsArticle>?
)

data class NewsArticle(
    var id: String?,
    var title: String?,
    var description: String?,
    var banner_url: String?,
    var time_created: String?,
    var rank: String?
)

fun NewsRemoteModel.toNewsDataModel(): NewsDataModel = NewsDataModel(this.articleList)
