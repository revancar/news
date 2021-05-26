package com.bangkit.news.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.news.core.domain.usecase.ArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(articleUseCase: ArticleUseCase): ViewModel() {
    val article = articleUseCase.getAllArticle().asLiveData()
}