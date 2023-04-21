package pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pt.guilhermerodrigues.goodbarbercodechallenge.articles.data.datasource.ArticleEndpoints
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HttpClientModule {
    @Singleton
    @Provides
    fun provideHttpClient(): Retrofit = Retrofit.Builder()
        .baseUrl(ArticleEndpoints.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}