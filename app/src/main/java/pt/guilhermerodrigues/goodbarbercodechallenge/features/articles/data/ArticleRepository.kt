package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.datasource.IArticleRemoteDataSource
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Response
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.IArticleRepository
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.ConnectionChecker
import java.sql.Connection
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val articleRemoteDataSource: IArticleRemoteDataSource
) : IArticleRepository {
    override suspend fun getArticles(): Result<Response> {
        if(ConnectionChecker.hasNetworkConnected) {
            return withContext(Dispatchers.IO) {
                try {
                    val response = articleRemoteDataSource.getArticles()
                    Log.d("response: ", response.toString())
                    Result.success(response)
                } catch (e: Exception) {
                    Result.failure(e)
                }
            }
        }
        return Result.failure(Exception("No internet connection"))
    }

    override suspend fun getArticle(id: Int, perPage: Int?, page: Int?): Result<Response> {
        if(ConnectionChecker.hasNetworkConnected) {
            return withContext(Dispatchers.IO) {
                try {
                    val article = articleRemoteDataSource.getArticle(id, perPage, page)
                    Result.success(article)
                } catch (e: Exception) {
                    Result.failure(e)
                }
            }
        }
        return Result.failure(Exception("No internet connection"))
    }
}