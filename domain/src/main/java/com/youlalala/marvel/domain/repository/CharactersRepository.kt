package com.youlalala.marvel.domain.repository

import com.youlalala.marvel.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getCharacters() : Flow<List<Character>>

    fun getCharacterDetail(id: Int) : Flow<List<Character>>
}