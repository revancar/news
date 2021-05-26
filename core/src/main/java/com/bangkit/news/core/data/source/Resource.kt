package com.bangkit.news.core.data.source

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T): com.bangkit.news.core.data.source.Resource<T>(data)
    class Loading<T>(data :T? = null) : com.bangkit.news.core.data.source.Resource<T>(data)
    class Error<T>(message: String?, data: T? = null) : com.bangkit.news.core.data.source.Resource<T>(data, message)
}