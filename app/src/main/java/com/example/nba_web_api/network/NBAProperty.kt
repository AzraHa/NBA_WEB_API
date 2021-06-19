package com.example.nba_web_api.network

data class NBAProperty(
    val data: Data,
)
data class Data(
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    val full_name: String,
    val id: Int,
    val name: String
)
