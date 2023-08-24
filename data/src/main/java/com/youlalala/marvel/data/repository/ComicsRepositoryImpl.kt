package com.youlalala.marvel.data.repository

import com.youlalala.marvel.data.Utils
import com.youlalala.marvel.data.datasource.ComicsRemoteDataSource
import com.youlalala.marvel.data.mapper.toDomain
import com.youlalala.marvel.data.mapper.toErrorMsg
import com.youlalala.marvel.domain.MarvelErrorException
import com.youlalala.marvel.domain.model.ComicList
import com.youlalala.marvel.domain.repository.ComicsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ComicsRepositoryImpl @Inject constructor(
    private val comicsDataSource: ComicsRemoteDataSource
) : ComicsRepository {

    override fun getComics(): Flow<Result<ComicList>> = flow {
        val ts = Utils.getTimesStamp()
        val response = comicsDataSource.getComics(ts, Utils.getTsHash(ts))
        if (response.isSuccessful){
            emit(Result.success(ComicList(response.body()!!.data.results.map { it.toDomain() })))
        }else{
            emit(Result.failure(MarvelErrorException(response.toErrorMsg())))
        }
}}


