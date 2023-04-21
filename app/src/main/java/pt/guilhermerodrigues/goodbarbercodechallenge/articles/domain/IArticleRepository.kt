package pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain

import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.Article

interface IArticleRepository {
    suspend fun getArticles(): Result<List<Article>>
    suspend fun getArticle(id: Int, perPage: Int?, page: Int?): Result<Article>
}