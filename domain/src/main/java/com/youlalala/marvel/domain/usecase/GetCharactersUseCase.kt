package com.youlalala.marvel.domain.usecase

import com.youlalala.marvel.domain.CharactersRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
){
    operator fun invoke() = flow{
        charactersRepository.getCharacters().collect{
            emit(it)
        }
    }
}
