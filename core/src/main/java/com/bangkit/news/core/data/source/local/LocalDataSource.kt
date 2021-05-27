package com.bangkit.news.core.data.source.local

import com.bangkit.news.core.data.source.local.entity.ArticleEntity
import com.bangkit.news.core.data.source.local.room.ArticleDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val articleDao: ArticleDao) {


    fun getAllArticles(): Flow<List<ArticleEntity>> = articleDao.getListArticle()

    fun getAllFavArticles(): Flow<List<ArticleEntity>> = articleDao.getArticlesFav()

    fun getArticlesByTitle(title: String): Flow<ArticleEntity> = articleDao.getArticleByTitle(title)

    suspend fun insertArticle(articleList: List<ArticleEntity>) = articleDao.insertArticle(articleList)

    fun setFavArticle(article: ArticleEntity, newState: Boolean) {
        article.isFavorite = newState
        articleDao.updateFavoriteArticle(article)
    }

}