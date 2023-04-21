package pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.datasource.IArticleRemoteDataSource
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ArticleRemoteDataSourceModule {
    @Singleton
    @Provides
    fun provideArticleRemoteDataSource(client: Retrofit): IArticleRemoteDataSource = client.create(IArticleRemoteDataSource::class.java)
}