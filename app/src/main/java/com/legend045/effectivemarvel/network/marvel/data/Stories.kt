package com.legend045.effectivemarvel.network.marvel.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stories(
    @Json(name = "available")
    val available: String,
    @Json(name = "collectionURI")
    val collectionURI: String,
    @Json(name = "items")
    val items: List<ItemXXX>,
    @Json(name = "returned")
    val returned: String
)
