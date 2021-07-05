package com.example.nba_web_api.database.nbaTeams

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.nba_web_api.network.dataNBA.NBATeams

@Dao
interface NBATeamsDAO {

    @Insert
    fun insert(nbaTeams: NBATeams)

    @Update
    fun update(nbaTeams: NBATeams)

    @Query("SELECT * from nba_teams_table WHERE id = :key")
    fun get(key: Int): NBATeams?

    @Query("DELETE from nba_teams_table")
    fun clear()

}