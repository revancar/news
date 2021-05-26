package com.bangkit.news.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bangkit.news.R
import com.bangkit.news.core.domain.model.Article
import com.bangkit.news.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {


    private val detailViewModel: DetailViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val detailArticle = intent.getParcelableExtra<Article>(EXTRA_DATA)
        showDetailArticle(detailArticle)

    }

    private fun showDetailArticle(detailArticle: Article?) {
        detailArticle?.let {
            binding.tvTitle.text = detailArticle.title
            binding.tvPublishedAt.text = detailArticle.publishedAt
            binding.tvAuthor.text = detailArticle.author
            binding.tvContent.text = detailArticle.content

            Glide.with(this@DetailActivity)
                .load(detailArticle.urlToImage)
                .into(binding.ivArticle)

            var statusFavorite = detailArticle.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteArticle(detailArticle, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite != true){
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))

        }else if (statusFavorite == true){
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
        }
    }
}