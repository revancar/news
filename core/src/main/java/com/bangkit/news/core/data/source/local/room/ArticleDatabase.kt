package com.bangkit.news.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangkit.news.core.data.source.local.entity.ArticleEntity

@Database(entities = [com.bangkit.news.core.data.source.local.entity.ArticleEntity::class], version = 1, exportSchema = false)
abstract class ArticleDatabase : RoomDatabase(){

    abstract fun articleDao(): com.bangkit.news.core.data.source.local.room.ArticleDao

}