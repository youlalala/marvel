package com.youlalala.marvel.data.dto

data class CharacterData(
    val description: String,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val thumbnail: ThumbnailData,
    val urlData: List<UrlData>
)