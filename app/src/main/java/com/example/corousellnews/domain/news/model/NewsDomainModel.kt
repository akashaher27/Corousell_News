package com.example.corousellnews.domain.news.model

import com.example.corousellnews.data.news.model.NewsArticle
import com.example.corousellnews.presenter.news.model.NewsPresenterModel
import com.example.corousellnews.presenter.news.view.ArticleModel

data class NewsDomainModel(
    var articleList: MutableList<NewsArticle>?
)

fun NewsDomainModel.toNewsPresenterModel(): NewsPresenterModel =
    NewsPresenterModel(mapToArticleModel(this.articleList))

private fun mapToArticleModel(newArticles: MutableList<NewsArticle>?): MutableList<ArticleModel> {
    var list: MutableList<ArticleModel> = mutableListOf()
    newArticles?.forEach {
        list.add(
            ArticleModel(
                it.id,
                it.title,
                it.description,
                it.banner_url,
                it.time_created,
                it.rank
            )
        )
    }
    return list
}
