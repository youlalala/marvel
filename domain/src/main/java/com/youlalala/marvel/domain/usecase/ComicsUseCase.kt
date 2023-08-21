package com.youlalala.marvel.domain.usecase

import com.youlalala.marvel.domain.model.ComicList
import kotlinx.coroutines.flow.Flow

interface ComicsUseCase {

//    fun getComics(): Flow<List<Comic>>

    fun getComics(): Flow<Result<ComicList>>

}