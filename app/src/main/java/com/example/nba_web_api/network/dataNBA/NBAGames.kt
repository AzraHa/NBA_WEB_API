package com.example.nba_web_api.network.dataNBA

data class NBAGames(
    val data: List<DataGame>,
)
data class DataGame(
    val date: String? = "",
    val home_team: HomeTeam,
    val home_team_score: Int? = 0,
    val id: Int,
    val period: Int? = 0,
    val postseason: Boolean? = false,
    val season: Int? = 0,
    val status: String? = "",
    val time: String? = "",
    val visitor_team: VisitorTeam,
    val visitor_team_score: Int? = 0
)
data class HomeTeam(
    val abbreviation: String? = "",
    val city: String? = "",
    val conference: String? = "",
    val division: String? = "",
    val full_name: String? = "",
    val id: Int,
    val name: String? = ""
)

data class VisitorTeam(
    val abbreviation: String? = "",
    val city: String? = "",
    val conference: String? = "",
    val division: String? = "",
    val full_name: String? = "",
    val id: Int,
    val name: String? = ""
)