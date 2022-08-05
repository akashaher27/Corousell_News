package com.example.corousellnews.presenter.news.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.common.view.recyclerview.BaseAdapter
import com.example.common.view.recyclerview.BaseViewHolder
import com.example.common.view.recyclerview.Item
import com.example.corousellnews.R

class ArticleAdapter(list: MutableList<ArticleModel>) :
    BaseAdapter<ArticleModel>(list) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ArticleModel> {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false), this
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ArticleModel>, position: Int) {
        holder.bindData(baseList[position])
    }
}

class RecipeViewHolder(view: View, adapter: ArticleAdapter) :
    BaseViewHolder<ArticleModel>(view, adapter) {

    private var banner = view.findViewById(R.id.ivBanner) as ImageView
    private var title = view.findViewById(R.id.tvTitle) as TextView
    private var description = view.findViewById(R.id.tvDescription) as TextView
    private var timeSpan = view.findViewById(R.id.tvTimeSpan) as TextView

    override fun bindData(item: ArticleModel) {
        Glide.with(view)
            .load(item.banner_url)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .transform(CenterCrop())
            .into(banner)
        title.text = item.title
        description.text = item.description
        timeSpan.text = item.time_created
    }
}

data class ArticleModel(
    var id: String?,
    var title: String?,
    var description: String?,
    var banner_url: String?,
    var time_created: String?,
    var timeSpanMillis: Long?,
    var rank: String?
) : Item()