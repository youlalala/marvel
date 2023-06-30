package com.youlalala.marvel.data.datasource

import com.youlalala.marvel.data.BuildConfig
import com.youlalala.marvel.data.dto.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersRemoteDataSource {

    /**
     * Fetches lists of comic characters with optional filters.
     */
    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("apikey") apikey: String = BuildConfig.MARVEL_PUBLIC_KEY
    ) : CharactersResponse

}