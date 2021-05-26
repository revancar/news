package com.bangkit.news.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse(


	@field:SerializedName("publishedAt")
	val publishedAt: String,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("urlToImage")
	val urlToImage: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("content")
	val content: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
)

