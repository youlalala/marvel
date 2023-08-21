package com.youlalala.marvel.domain.usecase

import com.youlalala.marvel.domain.model.Comic
import kotlinx.coroutines.flow.Flow

interface ComicsUseCase {

    fun getComics(): Flow<List<Comic>>

}