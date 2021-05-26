package com.bangkit.news.core.data.source.local

import androidx.lifecycle.LiveData
import com.bangkit.news.core.data.source.local.entity.ArticleEntity
import com.bangkit.news.core.data.source.local.room.ArticleDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val articleDao: com.bangkit.news.core.data.source.local.room.ArticleDao) {


    fun getAllArticles(): Flow<List<com.bangkit.news.core.data.source.local.entity.ArticleEntity>> = articleDao.getListArticle()

    fun getAllFavArticles(): Flow<List<com.bangkit.news.core.data.source.local.entity.ArticleEntity>> = articleDao.getArticlesFav()

    fun getArticlesByTitle(title: String): Flow<com.bangkit.news.core.data.source.local.entity.ArticleEntity> = articleDao.getArticleByTitle(title)

    suspend fun insertArticle(articleList: List<com.bangkit.news.core.data.source.local.entity.ArticleEntity>) = articleDao.insertArticle(articleList)

    fun setFavArticle(article: com.bangkit.news.core.data.source.local.entity.ArticleEntity, newState: Boolean) {
        article.isFavorite = newState
        articleDao.updateFavoriteArticle(article)
    }

}