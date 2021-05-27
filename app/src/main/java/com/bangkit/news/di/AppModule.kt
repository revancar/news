package com.bangkit.news.di

import com.bangkit.news.core.domain.usecase.ArticleInteractor
import com.bangkit.news.core.domain.usecase.ArticleUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideArticleUseCase(articleInteractor: ArticleInteractor): ArticleUseCase

}