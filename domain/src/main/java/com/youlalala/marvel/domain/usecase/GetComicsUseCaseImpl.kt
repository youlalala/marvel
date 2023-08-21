package com.youlalala.marvel.domain.usecase

import com.youlalala.marvel.domain.model.Comic
import com.youlalala.marvel.domain.repository.ComicsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ComicsUseCaseImpl @Inject constructor(
    private val comicsRepository: ComicsRepository
) : ComicsUseCase {
    override fun getComics() = flow{
        comicsRepository.getComics().collect{
            emit(it)
        }
    }
}