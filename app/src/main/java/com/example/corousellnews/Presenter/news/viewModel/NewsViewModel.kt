package com.example.corousellnews.Presenter.viewModel

import androidx.lifecycle.ViewModel
import com.example.corousellnews.Domain.news.NewsInteractor
import com.example.corousellnews.Presenter.news.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val newsInteractor: NewsInteractor) : BaseViewModel() {

    fun fetchNewsArticles() {
        newsInteractor.getNewsArticle()
    }
}