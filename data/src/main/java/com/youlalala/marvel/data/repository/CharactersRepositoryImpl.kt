package com.youlalala.marvel.data.repository

import com.youlalala.marvel.data.Utils
import com.youlalala.marvel.data.datasource.CharactersRemoteDataSource
import com.youlalala.marvel.data.mapper.toDomain
import com.youlalala.marvel.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.youlalala.marvel.domain.model.Character

class CharactersRepositoryImpl @Inject constructor(
    private val charactersDataSource: CharactersRemoteDataSource
) : CharactersRepository {

    override fun getCharacters(): Flow<List<Character>> = flow {
        val ts = Utils.getTimesStamp()
        val response = charactersDataSource.getCharacters(ts,Utils.getTsHash(ts))
        if(response.code == 200){
            emit(response.data.results.toDomain())
        }
    }

    override fun getCharacterDetail(id: Int): Flow<List<Character>> = flow {
        val ts = Utils.getTimesStamp()
        val response = charactersDataSource.getCharacterDetail(id, ts, Utils.getTsHash(ts))
        if (response.code == 200) {
            emit(response.data.results.toDomain())
        }
    }
}