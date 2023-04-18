package pt.guilhermerodrigues.goodbarbercodechallenge.core.common

sealed class UseCaseParams {
    data class ArticleParams(val articleId: Int)
}