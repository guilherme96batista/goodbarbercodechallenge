package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.IArticleRepository
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.usecases.GetArticle
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.usecases.GetArticles
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticleUseCaseModule {
    @Provides
    @Singleton
    fun provideArticleUseCase(repository: IArticleRepository): GetArticle = GetArticle(repository)

    @Provides
    @Singleton
    fun provideArticlesUseCase(repository: IArticleRepository): GetArticles = GetArticles(repository)
}