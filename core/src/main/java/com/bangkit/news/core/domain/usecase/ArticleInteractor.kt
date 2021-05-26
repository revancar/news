package com.bangkit.news.core.domain.usecase

import com.bangkit.news.core.domain.model.Article
import com.bangkit.news.core.domain.repository.iArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ArticleInteractor @Inject constructor(private val articleRepository: iArticleRepository): ArticleUseCase {

    override fun getAllArticle() = articleRepository.getAllArticle()

    override fun getFavouriteArticle() = articleRepository.getFavouriteArticle()

    override fun getArticleByTitle(title: String) = articleRepository.getArticleByTitle(title)

    override fun setFavouriteArticle(article: Article, state: Boolean) = articleRepository.setFavouriteArticle(article, state)

}