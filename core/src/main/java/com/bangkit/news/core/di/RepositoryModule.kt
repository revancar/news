package com.bangkit.news.core.di

import com.bangkit.news.core.data.source.ArticleRepository
import com.bangkit.news.core.domain.repository.iArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(articleRepository: ArticleRepository): iArticleRepository


}