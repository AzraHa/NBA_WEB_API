package com.example.nba_web_api.database.nbaPlayers

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.nba_web_api.network.dataNBA.PlayerTeam

@Dao
interface PlayerTeamDAO {

    @Insert
    fun insert(playerTeam: PlayerTeam)

    @Update
    fun update(playerTeam: PlayerTeam)

    @Query("SELECT * from player_team_table WHERE id = :key")
    fun get(key: Int): PlayerTeam?

    @Query("DELETE from player_team_table")
    fun clear()
}