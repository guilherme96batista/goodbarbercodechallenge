package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.datasource.IArticleRemoteDataSource
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Response
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.IArticleRepository
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.ConnectionChecker
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val _articleRemoteDataSource: IArticleRemoteDataSource
) : IArticleRepository {
    override suspend fun getArticles(perPage: Int?, page: Int?): Result<Response> {
        val result = withContext(Dispatchers.IO) {
            if (ConnectionChecker.isNetworkConnected()) {
                try {
                    val response = _articleRemoteDataSource.getArticles(perPage, page)
                    return@withContext Result.success(response)
                } catch (e: Exception) {
                    return@withContext Result.failure(e)
                }
            }
            return@withContext Result.failure(Exception("No internet connection"))
        }
        return result
    }

    override suspend fun getArticle(id: Int): Result<Response> {
        val result = withContext(Dispatchers.IO) {
            if (ConnectionChecker.isNetworkConnected()) {
                try {
                    val response = _articleRemoteDataSource.getArticle(id)
                    return@withContext Result.success(response)
                } catch (e: Exception) {
                    return@withContext Result.failure(e)
                }
            }
            return@withContext Result.failure(Exception("No internet connection"))
        }
        return result
    }
}