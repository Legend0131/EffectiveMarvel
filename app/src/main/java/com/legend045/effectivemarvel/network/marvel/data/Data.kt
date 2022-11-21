package com.legend045.effectivemarvel.network.marvel.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "count")
    val count: String,
    @Json(name = "limit")
    val limit: String,
    @Json(name = "offset")
    val offset: String,
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "total")
    val total: String
)
