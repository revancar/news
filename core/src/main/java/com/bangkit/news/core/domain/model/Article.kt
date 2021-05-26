package com.bangkit.news.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Article (
    var id : String?,
    var name: String?,
    var author: String,
    var title: String,
    var description: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String,
    var isFavorite: Boolean
): Parcelable