package com.youlalala.marvel.feature.comics

import com.youlalala.marvel.domain.model.Comic
import com.youlalala.marvel.domain.usecase.ComicsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetComicsUseCaseMock : ComicsUseCase {
    override fun getComics(): Flow<List<Comic>> {
        return flow { emit(listOf(Comic(1, "aaaa", "cdn.naver.com/image1"),
            Comic(2, "bbbbb", "cdn.naver.com/image2"))) }
    }
}