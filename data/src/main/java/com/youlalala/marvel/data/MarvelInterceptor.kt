package com.youlalala.marvel.data

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class MarvelInterceptor(): Interceptor {

    private val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    /*
    * Add query parameter
    * */
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val query = Utils.getTsHash()

        // Add your query parameters
        val modifiedUrl = originalUrl.newBuilder()
            .addQueryParameter("ts", query["ts"])
            .addQueryParameter("hash", query["hash"])
            .addQueryParameter("apikey",BuildConfig.MARVEL_PUBLIC_KEY)
            .build()

        val modifiedRequest = originalRequest.newBuilder()
            .url(modifiedUrl)
            .build()

        return chain.proceed(modifiedRequest)
    }

    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return httpLoggingInterceptor
    }
}