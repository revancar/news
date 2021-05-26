package com.bangkit.news.core.di

import android.content.Context
import androidx.room.Room
import com.bangkit.news.core.data.source.local.room.ArticleDao
import com.bangkit.news.core.data.source.local.room.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): com.bangkit.news.core.data.source.local.room.ArticleDatabase = Room.databaseBuilder(
        context,
        com.bangkit.news.core.data.source.local.room.ArticleDatabase::class.java, "ArticleNews.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideArticleDao(database: com.bangkit.news.core.data.source.local.room.ArticleDatabase): com.bangkit.news.core.data.source.local.room.ArticleDao = database.articleDao()

}