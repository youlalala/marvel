package com.youlalala.marvel.data.dto

data class CreatorsListData(
    val available: Int,
    val collectionURI: String,
    val items: List<CreatorData>,
    val returned: Int
)