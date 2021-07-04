package com.example.nba_web_api.network.dataNBA

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class NBATeams(
    val data: List<DataTeams>
)
@Parcelize
data class DataTeams(
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

