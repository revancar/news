@file:Suppress("AndroidUnresolvedRoomSqlReference")

package com.bangkit.news.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.bangkit.news.core.data.source.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM tb_article")
    fun getListArticle(): Flow<List<com.bangkit.news.core.data.source.local.entity.ArticleEntity>>

    @Query("SELECT * FROM tb_article WHERE isFavorite = 1")
    fun getArticlesFav(): Flow<List<com.bangkit.news.core.data.source.local.entity.ArticleEntity>>

    @Query("SELECT * FROM tb_article WHERE title = :title")
    fun getArticleByTitle(title: String) : Flow<com.bangkit.news.core.data.source.local.entity.ArticleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: List<com.bangkit.news.core.data.source.local.entity.ArticleEntity>)

    @Update
    fun updateFavoriteArticle(article: com.bangkit.news.core.data.source.local.entity.ArticleEntity)

}