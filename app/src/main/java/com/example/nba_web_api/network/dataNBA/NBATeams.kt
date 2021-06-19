package com.example.nba_web_api.network.dataNBA

data class NBATeams(
    val data: List<DataTeams>,
)
data class DataTeams(
    val abbreviation: String? = "",
    val city: String? = "",
    val conference: String? = "",
    val division: String? = "",
    val full_name: String? = "",
    val id: Int,
    val name: String? = ""
)

