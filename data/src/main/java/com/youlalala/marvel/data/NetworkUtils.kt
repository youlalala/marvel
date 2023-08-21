package com.youlalala.marvel.data

import retrofit2.Response
import java.lang.Exception

fun <T> Response<T>.checkResponse(): Response<T> {
    if (isSuccessful){
        return this
    }else{
        throw MarvelErrorException(
            code = code(),
            message = message()
        )
    }
}

class MarvelErrorException(
    val code: Int,
    override val message: String
): Exception(message)

