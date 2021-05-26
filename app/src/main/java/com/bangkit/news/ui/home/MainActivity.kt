package com.bangkit.news.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.news.R
import com.bangkit.news.core.ui.ArticleAdapter
import com.bangkit.news.databinding.ActivityMainBinding
import com.bangkit.news.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val mainActivityViewModel: MainActivityViewModel by viewModels ()


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val articleAdapter = ArticleAdapter()
        articleAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        mainActivityViewModel.article.observe(this, { article ->
            if(article != null){
                when(article) {
                    is com.bangkit.news.core.data.source.Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is com.bangkit.news.core.data.source.Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.textView.visibility = View.VISIBLE
                        articleAdapter.setData(article.data)
                    }
                    is com.bangkit.news.core.data.source.Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        with(binding.nested.rvArticle){
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = articleAdapter
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val mInflater =menuInflater
        mInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.favorite -> {
                val intent = Intent(this, Class.forName("com.bangkit.news.favorite.FavoriteActivity"))
                startActivity(intent)
                true
            }else -> true
        }
    }
}