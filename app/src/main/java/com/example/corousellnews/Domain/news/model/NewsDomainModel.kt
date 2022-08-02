package com.example.corousellnews.Domain.news.model

import com.example.corousellnews.Presenter.news.model.NewsPresenterModel

data class NewsDomainModel(
    val id: String?,
    val title: String?,
    val description: String?,
    val banner_url: String?,
    val time_created: String?,
    val rank: String?
)

fun NewsDomainModel.toNewsPresenterModel(): NewsPresenterModel = NewsPresenterModel(
    this.id,
    this.title,
    this.description,
    this.banner_url,
    this.time_created,
    this.rank
)
