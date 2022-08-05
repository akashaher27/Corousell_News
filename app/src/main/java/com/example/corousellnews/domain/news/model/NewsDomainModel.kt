package com.example.corousellnews.domain.news.model

import com.example.common.util.DateUtil
import com.example.corousellnews.data.news.model.NewsArticle
import com.example.corousellnews.presenter.news.model.NewsPresenterModel
import com.example.corousellnews.presenter.news.view.ArticleModel
import java.time.LocalDate
import kotlin.time.Duration.Companion.milliseconds

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
                toReadableTime(it.time_created),
                it.time_created?.toLong(),
                it.rank
            )
        )
    }
    return list
}

private fun toReadableTime(milis: String?): String {
    var diff: Long = 0
    var unit: String = ""
    return milis?.let {
        var diffMilis = System.currentTimeMillis() - milis.toLong()
        diff = diffMilis.milliseconds.inWholeHours
        unit = "hour"
        if (diff > 24) {
            diff = diffMilis.milliseconds.inWholeDays
            unit = "Days"
            if (diff > 30) {
                diff /= 30
                unit = "Month"
                if (diff > 12) {
                    diff /= 12
                    unit = "year"
                }
            }
        }
        "$diff $unit ago"
    } ?: "0"
}