package com.legend045.effectivemarvel.network.marvel.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Comics(
    @Json(name = "available")
    val available: String,
    @Json(name = "collectionURI")
    val collectionURI: String,
    @Json(name = "items")
    val items: List<Item>,
    @Json(name = "returned")
    val returned: String
)
