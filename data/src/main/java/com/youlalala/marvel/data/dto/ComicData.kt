package com.youlalala.marvel.data.dto

data class ComicData(
    val id: Int,
    val title: String,
    val urls: List<UrlData>,
    val priceData: List<PriceData>,
    val thumbnail: ThumbnailData,
    val creatorsListData: CreatorsListData
)