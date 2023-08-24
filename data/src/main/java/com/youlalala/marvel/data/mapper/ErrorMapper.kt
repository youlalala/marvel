package com.youlalala.marvel.data.mapper

import com.youlalala.marvel.domain.ErrorMessage
import retrofit2.Response

object ErrorMapper {

    fun toErrorMsg(code: Int): ErrorMessage {
        return when (code) {
            in 400..499 -> ErrorMessage.CLIENT_ERROR
            in 500..599 -> ErrorMessage.SERVER_ERROR
            else -> ErrorMessage.UNKNOWN_ERROR
        }
    }
}

fun Response<*>.toErrorMsg(): ErrorMessage {
    return ErrorMapper.toErrorMsg(this.code())
}
