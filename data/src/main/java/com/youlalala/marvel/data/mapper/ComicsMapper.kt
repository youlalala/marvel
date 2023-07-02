package com.youlalala.marvel.data.mapper

import com.youlalala.marvel.data.dto.ComicData
import com.youlalala.marvel.domain.model.Comic

object ComicsMapper {

    fun toDomain(data: List<ComicData>): List<Comic>{
        return data.map {
            Comic(
                id = it.id,
                title = it.title,
                thumbnail_url = it.thumbnail.path+"."+it.thumbnail.extension
            )
        }
    }
}

fun List<ComicData>.toDomain() : List<Comic> {
    return ComicsMapper.toDomain(this)
}