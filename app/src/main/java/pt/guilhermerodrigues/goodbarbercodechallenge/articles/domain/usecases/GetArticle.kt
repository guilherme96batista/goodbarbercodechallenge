package pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain.usecases

import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain.IArticleRepository
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCase
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCaseParams
import javax.inject.Inject

class GetArticle @Inject constructor(
    private val repository: IArticleRepository
) : UseCase<Result<Article>, UseCaseParams.ArticleParams> {
    override suspend fun invoke(params: UseCaseParams.ArticleParams): Result<Article> {
        return repository.getArticle(params.articleId, params.perPage, params.page)
    }
}