package pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain

import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCase
import javax.inject.Inject

class GetArticles @Inject constructor(
    private val repository: IArticleRepository
) : UseCase<List<Article>, Unit> {
    override suspend fun invoke(params: Unit): List<Article> {
        TODO("Not yet implemented")
    }
}