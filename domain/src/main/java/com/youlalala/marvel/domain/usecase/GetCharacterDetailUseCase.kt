package com.youlalala.marvel.domain.usecase

import com.youlalala.marvel.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
){
    operator fun invoke(
        id: Int
    ) = flow{
        charactersRepository.getCharacterDetail(id).collect{
            emit(it)
        }
    }
}
