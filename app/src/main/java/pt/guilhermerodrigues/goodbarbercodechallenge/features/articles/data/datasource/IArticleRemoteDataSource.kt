package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.datasource
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IArticleRemoteDataSource {
    @GET(ArticleEndpoints.ARTICLES)
    suspend fun getArticles(@Query("per_page") perPage: Int? = null, @Query("page") page: Int? = null): Response
    @GET(ArticleEndpoints.ARTICLE)
    suspend fun getArticle(@Path("id") id: Int, @Query("per_page") perPage: Int? = null, @Query("page") page: Int? = null): Response
}