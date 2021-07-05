package com.example.nba_web_api.network.dataNBA

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import kotlinx.android.parcel.Parcelize

data class NBAPlayers(
    val data: List<DataPlayers>
)

@Entity(tableName = "data_players_table")
@Parcelize
data class DataPlayers(
    @PrimaryKey
    val id: Int,
    val first_name: String? = "",
    val last_name: String? = "",
    val height_inches: Int? = 0,
    val height_feet: Int? = 0,
    val position: String? = "",
    @TypeConverters(Convertors::class)
    val team: PlayerTeam,
    val weight_pounds: Int? = 0
): Parcelable {
    val isRental
        get() = "rent"
}

class Convertors{
    @TypeConverter
    fun fromPlayerTeam(value: PlayerTeam?): Int? {
        return value?.id
    }

    @TypeConverter
    fun fromId(value: Int?): PlayerTeam?{
        return value?.let { PlayerTeam(it) }
    }
}

@Entity(tableName = "player_team_table")
@Parcelize
data class PlayerTeam(
    @PrimaryKey
    @TypeConverters(Convertors::class)
    val id: Int,
    val abbreviation: String? = "",
    val city: String? = "",
    val conference: String? = "",
    val division: String? = "",
    val full_name: String? = "",
    val name: String? = ""
): Parcelable {
    val isRental
        get() = "rent"
}
