package com.bangkit.news.core.data.source.remote

import android.util.Log
import com.bangkit.news.core.data.source.remote.network.ApiResponse
import com.bangkit.news.core.data.source.remote.network.ApiService
import com.bangkit.news.core.data.source.remote.response.ArticleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllArticles(): Flow<ApiResponse<List<ArticleResponse>>>{
        return flow {
            try {
                val response = apiService.getArticle()
                val dataArray = response.result
                Log.d("Response", response.toString())
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.result))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}