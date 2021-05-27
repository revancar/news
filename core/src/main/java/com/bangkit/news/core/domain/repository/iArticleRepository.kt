package com.bangkit.news.core.domain.repository

import com.bangkit.news.core.data.source.Resource
import com.bangkit.news.core.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface iArticleRepository {

    fun getAllArticle(): Flow<Resource<List<Article>>>

    fun getFavouriteArticle(): Flow<List<Article>>

    fun getArticleByTitle(title: String): Flow<List<Article>>

    fun setFavouriteArticle(article: Article, state: Boolean)

}