package com.bangkit.news.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListArticleResponse (

    @field:SerializedName("status")
    val status:Boolean,

    @field:SerializedName("message")
    val message:String,

    @field:SerializedName("articles")
    val result: List<ArticleResponse>

)