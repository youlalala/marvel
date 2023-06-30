package com.youlalala.marvel.data.di

import com.youlalala.marvel.data.repository.CharactersRepositoryImpl
import com.youlalala.marvel.domain.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsCharactersRepository(
        charactersRepositoryImpl: CharactersRepositoryImpl
    ): CharactersRepository
}