package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.ArticleRepository
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.IArticleRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindArticleRepository(
        repository: ArticleRepository
    ): IArticleRepository
}