package pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain

import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCase
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCaseParams
import javax.inject.Inject

class GetArticle @Inject constructor(
    private val repository: IArticleRepository
) : UseCase<Article, UseCaseParams.ArticleParams> {
    override suspend fun invoke(params: UseCaseParams.ArticleParams): Article {
        TODO("Not yet implemented")
    }
}