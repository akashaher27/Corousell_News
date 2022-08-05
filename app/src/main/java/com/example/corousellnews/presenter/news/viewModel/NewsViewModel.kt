package com.example.corousellnews.presenter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.util.DateUtil
import com.example.corousellnews.domain.news.NewsInteractor
import com.example.corousellnews.domain.news.model.toNewsPresenterModel
import com.example.corousellnews.presenter.news.BaseViewModel
import com.example.corousellnews.presenter.news.model.NewsPresenterModel
import com.example.corousellnews.presenter.news.view.ArticleModel
import com.example.practiceproject.app.remote.retrofit.OnError
import com.example.practiceproject.app.remote.retrofit.Response
import com.example.practiceproject.app.remote.retrofit.Success
import com.example.practiceproject.app.rxjava.RxDisposableFlowableObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val newsInteractor: NewsInteractor) : BaseViewModel() {

    private var newsArticleLiveData = MutableLiveData<Response<NewsPresenterModel>>()
    fun getNewArticles(): LiveData<Response<NewsPresenterModel>> = newsArticleLiveData
    fun fetchNewsArticles() {
        addDisposable(newsInteractor.getNewsArticle()
            .map {
                it.toNewsPresenterModel()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(NewsArticleSubscriber()))
    }

    inner class NewsArticleSubscriber :
        RxDisposableFlowableObserver<NewsPresenterModel>(uiResolution) {
        override fun success(t: NewsPresenterModel) {
            newsArticleLiveData.value = Success(t)
        }

        override fun error(e: Throwable?) {
            newsArticleLiveData.value = OnError(e?.message)
        }

        override fun complete() {

        }

    }

    fun sortArticleByTime(): List<ArticleModel> {
        var list = newsArticleLiveData.value?.data?.articleList
        list?.sortByDescending {
            it.timeSpanMillis
        }
        return list?.toList() ?: emptyList()
    }

    fun getArticleByPopularity(): List<ArticleModel> {
        var list = newsArticleLiveData.value?.data?.articleList
        list?.sortBy {
            it.rank
        }
        return list?.toList() ?: emptyList()
    }
}