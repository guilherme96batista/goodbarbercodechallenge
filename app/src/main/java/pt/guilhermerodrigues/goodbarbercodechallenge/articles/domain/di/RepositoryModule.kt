package pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.ArticleRepositoryImpl
import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.datasource.IArticleRemoteDataSource
import pt.guilhermerodrigues.goodbarbercodechallenge.articles.domain.IArticleRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideArticleRepository(remoteDataSource: IArticleRemoteDataSource): IArticleRepository = ArticleRepositoryImpl(remoteDataSource)
}