package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.datasource.ArticleEndpoints
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
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
        )
        .build()
}