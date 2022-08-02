package com.example.corousellnews.Data.news.repo

import com.example.corousellnews.Data.news.model.NewsDataModel
import com.example.corousellnews.Data.news.model.NewsRemoteModel

interface NewsRepo {

    fun getNewasArticle(): List<NewsDataModel>
}