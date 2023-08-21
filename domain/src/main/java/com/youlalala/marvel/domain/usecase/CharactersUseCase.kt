package com.youlalala.marvel.domain.usecase

import com.youlalala.marvel.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersUseCase {

    fun getCharacters(): Flow<List<Character>>

    fun getCharacterDetail(id: Int): Flow<List<Character>>

}