package com.youlalala.marvel.data.dto

data class ComicsListData(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicData>,
    val returned: Int
)