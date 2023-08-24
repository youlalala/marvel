package com.youlalala.marvel.domain

import java.lang.Exception

class MarvelErrorException(
    val code: ErrorMessage,
): Exception()

enum class ErrorMessage{
    CLIENT_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR,
}