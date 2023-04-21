package pt.guilhermerodrigues.goodbarbercodechallenge.articles.data

import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.datasource.IArticleRemoteDataSource
import pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain.IArticleRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepositoryImpl @Inject constructor(
    private val articleRemoteDataSource: IArticleRemoteDataSource
): IArticleRepository {
    override suspend fun getArticles(): Result<List<Article>> {
        return try {
            val articles = articleRemoteDataSource.getArticles()
            Result.success(articles)
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getArticle(id: Int, perPage: Int?, page: Int?): Result<Article> {
        return try {
            val article = articleRemoteDataSource.getArticle(id, perPage, page)
            Result.success(article)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}