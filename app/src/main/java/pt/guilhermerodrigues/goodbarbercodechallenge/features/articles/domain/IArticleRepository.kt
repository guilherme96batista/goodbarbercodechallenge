package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain

import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Response

interface IArticleRepository {
    suspend fun getArticles(perPage: Int?, page: Int?): Result<Response>
    suspend fun getArticle(id: Int): Result<Response>
}