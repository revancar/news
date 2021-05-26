package com.bangkit.news.ui.detail

import androidx.lifecycle.ViewModel
import com.bangkit.news.core.domain.model.Article
import com.bangkit.news.core.domain.usecase.ArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val articleUseCase: ArticleUseCase) : ViewModel() {
    fun setFavoriteArticle(article: Article, newStatus: Boolean) =
        articleUseCase.setFavouriteArticle(article, newStatus)
}