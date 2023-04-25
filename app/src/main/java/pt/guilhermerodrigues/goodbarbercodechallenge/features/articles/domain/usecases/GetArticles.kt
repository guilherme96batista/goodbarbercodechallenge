package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.usecases

import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.IArticleRepository
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCase
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCaseParams
import javax.inject.Inject

class GetArticles @Inject constructor(
    private val repository: IArticleRepository
) : UseCase<Result<List<Article>>, UseCaseParams.ArticleListParams> {
    override suspend fun invoke(params: UseCaseParams.ArticleListParams): Result<List<Article>> {
        val result = repository.getArticles(params.perPage, params.page)
        result.fold(
            onSuccess = {
                return Result.success(it.items)
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }
}