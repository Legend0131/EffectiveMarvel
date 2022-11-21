package com.legend045.effectivemarvel.network.marvel.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroesData(
    @Json(name = "attributionHTML")
    val attributionHTML: String,
    @Json(name = "attributionText")
    val attributionText: String,
    @Json(name = "code")
    val code: String,
    @Json(name = "copyright")
    val copyright: String,
    @Json(name = "data")
    val data: Data,
    @Json(name = "etag")
    val etag: String,
    @Json(name = "status")
    val status: String
)
