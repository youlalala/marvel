package com.youlalala.marvel.data.di

import com.youlalala.marvel.data.datasource.CharactersRemoteDataSource
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
}