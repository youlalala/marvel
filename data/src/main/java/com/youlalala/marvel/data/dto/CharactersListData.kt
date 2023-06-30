package com.youlalala.marvel.data.dto

data class CharactersListData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<CharacterData>,
    val total: Int
)