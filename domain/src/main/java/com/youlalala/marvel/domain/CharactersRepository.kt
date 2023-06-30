package com.youlalala.marvel.domain

import com.youlalala.marvel.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getCharacters() : Flow<List<Character>>
}