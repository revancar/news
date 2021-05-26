package com.bangkit.news.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.news.core.domain.usecase.ArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(articleUseCase: ArticleUseCase): ViewModel() {
    val favoriteArticle = articleUseCase.getFavouriteArticle().asLiveData()
}