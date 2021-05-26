package com.bangkit.news.core.data.source.remote.network

import com.bangkit.news.core.data.source.remote.response.ListArticleResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v2/top-headlines?sources=bbc-news&apiKey=6ad6ea93b8bd49349a650ba2118a1bff")
    suspend fun getArticle(): ListArticleResponse
}