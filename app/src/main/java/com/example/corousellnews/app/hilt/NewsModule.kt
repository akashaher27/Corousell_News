package com.example.corousellnews.app.hilt

import com.example.corousellnews.data.news.remote.NewsApi
import com.example.corousellnews.data.news.remote.NewsApiImp
import com.example.corousellnews.data.news.repo.NewsRepo
import com.example.corousellnews.data.news.repo.NewsRepoImp
import com.example.corousellnews.domain.news.NewsInteractor
import com.example.corousellnews.domain.news.NewsInteractorImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NewsModule {

    @Binds
    abstract fun provideNewsInteractor(newsInteractorImp: NewsInteractorImp): NewsInteractor

    @Binds
    abstract fun provideNewsRepo(newsRepoImp: NewsRepoImp): NewsRepo

    @Binds
    abstract fun provideNewsApi(newsApiImp: NewsApiImp): NewsApi

}