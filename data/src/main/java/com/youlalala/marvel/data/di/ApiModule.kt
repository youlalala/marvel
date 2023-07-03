package com.youlalala.marvel.data.di

import com.youlalala.marvel.data.datasource.CharactersRemoteDataSource
import com.youlalala.marvel.data.datasource.ComicsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideCharactersDataSource(retrofit: Retrofit): CharactersRemoteDataSource {
        return retrofit.create(CharactersRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideComicsDataSource(retrofit: Retrofit): ComicsRemoteDataSource {
        return retrofit.create(ComicsRemoteDataSource::class.java)
    }
}