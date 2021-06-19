package com.example.nba_web_api.network

import com.example.nba_web_api.network.dataNBA.NBAGames
import com.example.nba_web_api.network.dataNBA.NBAOneTeam
import com.example.nba_web_api.network.dataNBA.NBAPlayers
import com.example.nba_web_api.network.dataNBA.NBATeams
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private val logging : HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
val httpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logging)
private const val BASE_URL = "https://free-nba.p.rapidapi.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(httpClient.build())
    .build()

interface NBAApiService {
    @Headers(
        "X-Rapidapi-Key: 7e7560beebmshd996222ae228edap123221jsn2926c218329d",
        "X-Rapidapi-Host: free-nba.p.rapidapi.com"
    )
   // @GET("players")
    //fun getPlayers(@Query("search") search: String): Call<NBAPlayers>

   @GET("teams")
    fun getTeams(): Call<NBATeams>

  //  @GET("teams/14")
   // fun getSpecificTeam() : Call<NBAOneTeam>

  // @GET("games")
    //fun getGames(@Query("per_page") search: String): Call<NBAGames>

}

object NBAApi {
    val retrofitService : NBAApiService by lazy {
        retrofit.create(NBAApiService::class.java) }
}