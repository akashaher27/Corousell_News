package com.example.corousellnews.Data.news.model

import com.example.corousellnews.Domain.news.model.NewsDomainModel

data class NewsRemoteModel(
    val id: String?,
    val title: String?,
    val description: String?,
    val banner_url: String?,
    val time_created: String?,
    val rank: String?
)

fun NewsRemoteModel.toNewsDataModel(): NewsDataModel = NewsDataModel(
    this.id,
    this.title,
    this.description,
    this.banner_url,
    this.time_created,
    this.rank
)
