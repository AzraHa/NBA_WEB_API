package com.example.movies_web_api.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://www.free-nba.p.rapidapi.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NBAApiService {
    @Headers(
        "X-Rapidapi-Key: 7e7560beebmshd996222ae228edap123221jsn2926c218329d" ,
        "X-Rapidapi-Host: free-nba.p.rapidapi.com"
    )
    @GET("teams")
    fun getProperties():
            Call<List<NBAProperty>>
}

object NBAApi {
    val retrofitService : NBAApiService by lazy {
        retrofit.create(NBAApiService::class.java) }
}