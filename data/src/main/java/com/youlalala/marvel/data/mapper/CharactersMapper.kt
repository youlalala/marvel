package com.youlalala.marvel.data.mapper

import com.youlalala.marvel.data.dto.CharacterData
import com.youlalala.marvel.domain.model.Character

object CharactersMapper {

    fun toDomain(data: List<CharacterData>): List<Character>{
        return data.map {
            Character(
                id = it.id,
                name = it.name,
                thumbnail_url = it.thumbnail.path+"."+it.thumbnail.extension,
                description = it.description,
            )
        }
    }
}

fun List<CharacterData>.toDomain() : List<Character> {
    return CharactersMapper.toDomain(this)
}

