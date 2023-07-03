package com.youlalala.marvel.data.datasource

import com.youlalala.marvel.data.BuildConfig
import com.youlalala.marvel.data.dto.ComicsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicsRemoteDataSource {

    /**
     * Fetches lists of comics with optional filters.
     */
    @GET("comics")
    suspend fun getComics(
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("apikey") apikey: String = BuildConfig.MARVEL_PUBLIC_KEY
    ) : ComicsResponse

}