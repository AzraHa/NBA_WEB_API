package com.example.nba_web_api.network

data class NBAProperty(
    val data : List<Data>,
    val meta : Meta
)
data class Data (
    val id : Int,
    val abbreviation : String,
    val city : String,
    val conference : String,
    val division : String,
    val full_name : String,
    val name : String
)
data class Meta (

    val total_pages : Int,
    val current_page : Int,
    val next_page : String,
    val per_page : Int,
    val total_count : Int
)