package com.bangkit.news.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.news.DaggerMyApplication_HiltComponents_SingletonC
import com.bangkit.news.core.ui.ArticleAdapter
import com.bangkit.news.favorite.databinding.ActivityFavoriteBinding
import com.bangkit.news.ui.detail.DetailActivity
import com.bangkit.news.di.FavoriteModuleDepedencies
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import dagger.internal.DaggerCollections
import javax.inject.Inject


class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }



    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDepedencies::class.java
                )
            )
            .build().inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val articleAdapter = ArticleAdapter()
        articleAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteArticle.observe(this, { dataArticle ->
            if (dataArticle != null){
                articleAdapter.setData(dataArticle)
                binding.textView.visibility = View.VISIBLE
            }
        })
        with(binding.nested.rvArticle) {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
            adapter = articleAdapter
        }
    }
}