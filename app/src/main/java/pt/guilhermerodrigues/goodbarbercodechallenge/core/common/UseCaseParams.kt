package pt.guilhermerodrigues.goodbarbercodechallenge.core.common

sealed class UseCaseParams {
    data class ArticleParams(val articleId: Int, val perPage: Int? = null, val page: Int? = null)
}