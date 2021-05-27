package com.bangkit.news.core.data.source

import com.bangkit.news.core.data.source.local.LocalDataSource
import com.bangkit.news.core.data.source.remote.RemoteDataSource
import com.bangkit.news.core.data.source.remote.network.ApiResponse
import com.bangkit.news.core.data.source.remote.response.ArticleResponse
import com.bangkit.news.core.domain.model.Article
import com.bangkit.news.core.domain.repository.iArticleRepository
import com.bangkit.news.core.utils.AppExecutors
import com.bangkit.news.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : iArticleRepository{


    override fun getAllArticle(): Flow<Resource<List<Article>>> =
        object : com.bangkit.news.core.data.source.NetworkBoundResource<List<Article>, List<ArticleResponse>>(){
            override fun loadFromDB(): Flow<List<Article>> {
                return localDataSource.getAllArticles().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Article>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ArticleResponse>>> =
                remoteDataSource.getAllArticles()

            override suspend fun saveCallResult(data: List<ArticleResponse>) {
                val articleList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertArticle(articleList)
            }
        }.asFlow()

    override fun getArticleByTitle(title: String): Flow<List<Article>> {
        TODO("Not yet implemented")
    }



    override fun getFavouriteArticle(): Flow<List<Article>> {
        return localDataSource.getAllFavArticles().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }



    override fun setFavouriteArticle(article: Article, state: Boolean) {
        val articleEntity = DataMapper.mapDomainToEntity(article)
        appExecutors.diskIO().execute { localDataSource.setFavArticle(articleEntity, state) }
    }

}