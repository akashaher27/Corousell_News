package com.example.corousellnews.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practiceproject.app.common.ErrorResolution
import com.example.practiceproject.view.common.UiResolution
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel() : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val errorResolution: MutableLiveData<ErrorResolution> = MutableLiveData()
    protected val uiResolution: UiResolution by lazy {
        UiResolution(errorResolution)
    }

    fun getNetworkError(): LiveData<ErrorResolution> = errorResolution

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }
}