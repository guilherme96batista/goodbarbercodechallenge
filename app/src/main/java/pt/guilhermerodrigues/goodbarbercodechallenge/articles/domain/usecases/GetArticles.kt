package pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain.usecases

import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain.IArticleRepository
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCase
import javax.inject.Inject

class GetArticles @Inject constructor(
    private val repository: IArticleRepository
) : UseCase<Result<List<Article>>, Unit> {
    override suspend fun invoke(params: Unit): Result<List<Article>> {
        return repository.getArticles()
    }
}