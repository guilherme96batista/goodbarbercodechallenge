package pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.datasource
import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.Article
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IArticleRemoteDataSource {
    @GET(ArticleEndpoints.ARTICLES)
    suspend fun getArticles(): List<Article>
    @GET(ArticleEndpoints.ARTICLE)
    suspend fun getArticle(@Path("id") id: Int, @Query("per_page") perPage: Int? = null, @Query("page") page: Int? = null): Article
}