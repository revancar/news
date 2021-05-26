package com.bangkit.news.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.news.core.R
import com.bangkit.news.core.databinding.ItemRowArticleBinding
import com.bangkit.news.core.domain.model.Article
import com.bumptech.glide.Glide

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ListViewHolder>(){

    private var listData = ArrayList<Article>()
    var onItemClick: ((Article) -> Unit)? = null

    fun setData(newListData: List<Article>?){
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemRowArticleBinding.bind(itemView)
        fun bind(data: Article){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.urlToImage)
                    .into(imageView)

                author.text = data.author
                titleArticle.text = data.title
                desc.text = data.description
                timeArticle.text = data.publishedAt
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_article, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount()= listData.size

}