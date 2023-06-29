package com.youlalala.marvel.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /*
    * Create the MarvelInterceptor instance
    * */
    @Provides
    @Singleton
    internal fun provideInterceptor(): MarvelInterceptor {
        return MarvelInterceptor()
    }

    /*
    * Create the OkHttpClient instance
    * */
    @Provides
    @Singleton
    fun providesOkHttpClient(interceptor: MarvelInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor.getLoggingInterceptor())
            .connectTimeout(10000, TimeUnit.SECONDS)
            .writeTimeout(10000, TimeUnit.SECONDS)
            .readTimeout(30000, TimeUnit.SECONDS)
            .build()
    }

    /*
    * Create the Retrofit instance
    * */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.MARVEL_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}