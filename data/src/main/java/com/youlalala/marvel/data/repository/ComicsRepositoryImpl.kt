package com.youlalala.marvel.data.repository

import com.youlalala.marvel.data.Utils
import com.youlalala.marvel.data.checkResponse
import com.youlalala.marvel.data.datasource.ComicsRemoteDataSource
import com.youlalala.marvel.data.mapper.toDomain
import com.youlalala.marvel.domain.model.ComicList
import com.youlalala.marvel.domain.repository.ComicsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject


class ComicsRepositoryImpl @Inject constructor(
    private val comicsDataSource: ComicsRemoteDataSource
) : ComicsRepository {

    override fun getComics(): Flow<Result<ComicList>> = flow {
        val ts = Utils.getTimesStamp()
        try {
            // success test
            val response = comicsDataSource.getComics(ts, Utils.getTsHash(ts)).checkResponse()
            // error test
            //val response = comicsDataSource.getComics("", Utils.getTsHash(ts)).checkResponse()
            emit(Result.success(ComicList(response.body()!!.data.results.toDomain())))
        }catch (e: Exception){
            emit(Result.failure(e))
        }
}}
