package com.youlalala.marvel.domain.repository

import com.youlalala.marvel.domain.model.Comic
import kotlinx.coroutines.flow.Flow

interface ComicsRepository {

    fun getComics() : Flow<List<Comic>>
}