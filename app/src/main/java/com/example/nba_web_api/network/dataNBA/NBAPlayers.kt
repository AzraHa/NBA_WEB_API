package com.example.nba_web_api.network.dataNBA

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class NBAPlayers(
    val data: List<DataPlayers>
)

@Parcelize
data class DataPlayers(
    val id: Int,
    val first_name: String? = "",
    val last_name: String? = "",
    val height_inches: Int? = 0,
    val height_feet: Int? = 0,
    val position: String? = "",
    val team: PlayerTeam,
    val weight_pounds: Int? = 0
): Parcelable {
    val isRental
        get() = "rent"
}

@Parcelize
data class PlayerTeam(
    val abbreviation: String? = "",
    val city: String? = "",
    val conference: String? = "",
    val division: String? = "",
    val full_name: String? = "",
    val id: Int,
    val name: String? = ""
): Parcelable {
    val isRental
        get() = "rent"
}
