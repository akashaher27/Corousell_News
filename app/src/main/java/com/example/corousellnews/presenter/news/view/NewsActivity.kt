package com.example.corousellnews.presenter.news.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.corousellnews.R
import com.example.corousellnews.presenter.viewModel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    private val viewmodel: NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        viewmodel.fetchNewsArticles()
        viewmodel.getNewArticles().observe(this,{
            Log.d("TAG", "onCreate: ")
        })
    }
}