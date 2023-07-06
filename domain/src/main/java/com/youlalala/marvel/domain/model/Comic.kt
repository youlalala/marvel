package com.youlalala.marvel.domain.model

data class Comic(
    val id: Int,
    val title: String,
    val thumbnail_url: String = ""
)