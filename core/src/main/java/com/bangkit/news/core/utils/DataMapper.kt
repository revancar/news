package com.bangkit.news.core.utils

import com.bangkit.news.core.data.source.local.entity.ArticleEntity
import com.bangkit.news.core.data.source.remote.response.ArticleResponse
import com.bangkit.news.core.domain.model.Article

object DataMapper {

    fun mapResponseToEntities(input: List<ArticleResponse>): List<ArticleEntity> {
        val articleList = ArrayList<ArticleEntity>()
        input.map {
            val article = ArticleEntity(
                id = it.id,
                name = it.name,
                author = it.author,
                title = it.title,
                description = it.description,
                urlToImage = it.urlToImage,
                publishedAt = it.publishedAt,
                content = it.content,
                isFavorite = false
            )
            articleList.add(article)
        }
        return articleList
    }

    fun mapEntitiesToDomain(input: List<ArticleEntity>): List<Article> =
        input.map {
            Article(
                id = it.id,
                name = it.name,
                author = it.author,
                title = it.title,
                description = it.description,
                urlToImage = it.urlToImage,
                publishedAt = it.publishedAt,
                content = it.content,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Article) =
        ArticleEntity(
            id = input.id,
            name = input.name,
            author = input.author,
            title = input.title,
            description = input.description,
            urlToImage = input.urlToImage,
            publishedAt = input.publishedAt,
            content = input.content,
            isFavorite = input.isFavorite
        )

}