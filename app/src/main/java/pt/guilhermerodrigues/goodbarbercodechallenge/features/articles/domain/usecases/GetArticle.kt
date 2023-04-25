package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.usecases

import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.IArticleRepository
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCase
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCaseParams
import javax.inject.Inject

class GetArticle @Inject constructor(
    private val repository: IArticleRepository
) : UseCase<Result<Article>, UseCaseParams.ArticleParams> {
    override suspend fun invoke(params: UseCaseParams.ArticleParams): Result<Article> {
        val result = repository.getArticle(params.articleId)
        result.fold(
            onSuccess = {
                return Result.success(it.items.first())
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }
}