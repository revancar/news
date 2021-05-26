package com.bangkit.news.di

import com.bangkit.news.core.domain.usecase.ArticleInteractor
import com.bangkit.news.core.domain.usecase.ArticleUseCase
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDepedencies {

    fun getFavUsecase(): ArticleUseCase
    
}