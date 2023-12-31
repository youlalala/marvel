package com.youlalala.marvel.domain.di

import com.youlalala.marvel.domain.repository.CharactersRepository
import com.youlalala.marvel.domain.repository.ComicsRepository
import com.youlalala.marvel.domain.usecase.CharactersUseCase
import com.youlalala.marvel.domain.usecase.CharactersUseCaseImpl
import com.youlalala.marvel.domain.usecase.ComicsUseCase
import com.youlalala.marvel.domain.usecase.ComicsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetComicsUseCase(repository: ComicsRepository) : ComicsUseCase {
        return ComicsUseCaseImpl(repository)
    }

    @Singleton
    @Provides
fun provideGetCharactersUseCase(repository: CharactersRepository) : CharactersUseCase {
        return CharactersUseCaseImpl(repository)
    }

}