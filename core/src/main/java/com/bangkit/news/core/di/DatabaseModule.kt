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
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ArticleDatabase {
        val passPhrase: ByteArray = SQLiteDatabase.getBytes("bangkit".toCharArray())
        val factory = SupportFactory(passPhrase)
            return Room.databaseBuilder(
            context,
            ArticleDatabase::class.java, "ArticleNews.db"
        ).fallbackToDestructiveMigration().openHelperFactory(factory).build()
    }

    @Provides
    fun provideArticleDao(database: ArticleDatabase): ArticleDao = database.articleDao()
}