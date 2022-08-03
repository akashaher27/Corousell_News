package com.example.corousellnews.presenter.news.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.corousellnews.R
import com.example.corousellnews.databinding.ActivityNewsBinding
import com.example.corousellnews.presenter.news.model.NewsPresenterModel
import com.example.corousellnews.presenter.viewModel.NewsViewModel
import com.example.practiceproject.app.remote.retrofit.Loading
import com.example.practiceproject.app.remote.retrofit.OnError
import com.example.practiceproject.app.remote.retrofit.Response
import com.example.practiceproject.app.remote.retrofit.Success
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_news.*

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    private val viewmodel: NewsViewModel by viewModels()
    private var binding: ActivityNewsBinding? = null
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
    }

    private fun initialiseView() {
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.arvArticlesList?.initRecyclerView {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = ArticleAdapter(mutableListOf())
            it.adapter = adapter
        }

        makeNetworkCall()
        setupObserver()
    }

    private fun setupObserver() {
        viewmodel.getNewArticles().observe(this) {
            handleNewArticleReponse(it)
        }
    }

    private fun handleNewArticleReponse(response:Response<NewsPresenterModel>) {
        when (response) {
            is Loading -> {
                progressBar.visibility = View.VISIBLE
            }
            is Success -> {
                progressBar.visibility = View.GONE
                response.data?.articleList?.let {
                    adapter.addItems(it)
                }
            }
            is OnError -> {
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun makeNetworkCall() {
        viewmodel.fetchNewsArticles()
    }
}