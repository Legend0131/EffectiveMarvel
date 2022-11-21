package com.legend045.effectivemarvel.network

import com.legend045.effectivemarvel.network.marvel.data.HeroesData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val TIME_SET = "1"
private const val PUBLIC_KEY = "bdebe6fb6c9cb40bd41f04751115ecb5"
private const val HASH = "0a6f4ce73f3187b26eb925ed52b3cdbb"
private const val BASE_URL = "http://gateway.marvel.com"

private const val HEROES_END = "/v1/public/characters?ts=${TIME_SET}&apikey=${PUBLIC_KEY}&hash=$HASH"
private const val HERO_END =
    "/v1/public/characters/{characterId}?ts=${TIME_SET}&apikey=${PUBLIC_KEY}&hash=$HASH"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MarvelApiService {
    @GET(HEROES_END) //photos
    suspend fun getData(): HeroesData
}
interface MarvelApiService2{
    @GET(HERO_END)
    suspend fun getHero(@Path("characterId")id: String):com.legend045.effectivemarvel.network.marvel.data.Result
}

object MarvelApi {
    val retrofitService : MarvelApiService by lazy {
        retrofit.create(MarvelApiService::class.java) }

    val retrofitService2 : MarvelApiService2 by lazy {
        retrofit.create(MarvelApiService2::class.java)
    }
}
