package com.bangkit.news.core.data.source.local.entity
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_article")
@Parcelize
data class ArticleEntity (

    @PrimaryKey
    @ColumnInfo(name = "title")
    var title: String,


    @ColumnInfo(name = "id")
    var id : String?,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "author")
    var author: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "urlToImage")
    var urlToImage: String,

    @ColumnInfo(name = "publishedAt")
    var publishedAt: String,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false


):Parcelable