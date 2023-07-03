package com.youlalala.marvel.domain.usecase

import com.youlalala.marvel.domain.repository.ComicsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(
    private val comicsRepository: ComicsRepository
){
    operator fun invoke() = flow{
        comicsRepository.getComics().collect{
            emit(it)
        }
    }
}