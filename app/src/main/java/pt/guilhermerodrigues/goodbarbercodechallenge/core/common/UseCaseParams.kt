package pt.guilhermerodrigues.goodbarbercodechallenge.core.common

sealed class UseCaseParams {
    data class ArticleParams(val articleId: Int)
    data class ArticleListParams(val perPage: Int? = null, val page: Int? = null)
}