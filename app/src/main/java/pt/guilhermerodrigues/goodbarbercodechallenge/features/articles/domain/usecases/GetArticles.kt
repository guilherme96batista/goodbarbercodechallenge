package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.usecases

import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.IArticleRepository
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCase
import javax.inject.Inject

class GetArticles @Inject constructor(
    private val repository: IArticleRepository
) : UseCase<Result<List<Article>>, Unit> {
    override suspend fun invoke(params: Unit): Result<List<Article>> {
        val result = repository.getArticles()
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