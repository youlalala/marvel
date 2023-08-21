package com.youlalala.marvel.domain.repository

import com.youlalala.marvel.domain.model.ComicList
import kotlinx.coroutines.flow.Flow

interface ComicsRepository {

//    fun getComics() : Flow<List<Comic>>
    fun getComics() : Flow<Result<ComicList>>
}