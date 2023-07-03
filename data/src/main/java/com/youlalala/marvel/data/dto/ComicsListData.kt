package com.youlalala.marvel.data.dto

data class ComicsListData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ComicData>,
    val total: Int
)