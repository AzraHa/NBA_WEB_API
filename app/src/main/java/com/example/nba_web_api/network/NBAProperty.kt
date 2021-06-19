package com.example.nba_web_api.network

data class NBAProperty(
    val data: List<Data>
)
data class Data(
    val first_name: String? = "",
    val height_feet: Int? = 0,
    val height_inches: Int? = 0,
    val id: Int,
    val last_name: String? = "",
    val position: String? = "",
    val team: Team,
    val weight_pounds: Int? = 0
)

data class Team(
    val abbreviation: String? = "",
    val city: String? = "",
    val conference: String? = "",
    val division: String? = "",
    val full_name: String? = "",
    val id: Int,
    val name: String? = ""
)