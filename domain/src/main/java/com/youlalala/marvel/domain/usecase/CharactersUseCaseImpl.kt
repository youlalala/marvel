package com.youlalala.marvel.domain.usecase

import com.youlalala.marvel.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharactersUseCaseImpl @Inject constructor(
    private val charactersRepository: CharactersRepository,
): CharactersUseCase {

    override fun getCharacters() = flow {
        charactersRepository.getCharacters().collect{
            emit(it)
        }
    }

    override fun getCharacterDetail(id: Int) = flow {
        charactersRepository.getCharacterDetail(id).collect{
            emit(it)
        }
    }
}