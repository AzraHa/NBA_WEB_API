package com.example.nba_web_api.database.nbaPlayers

import androidx.room.*
import com.example.nba_web_api.network.dataNBA.DataPlayers
import retrofit2.http.Query

@Dao
interface DataPlayersDAO {

    @Insert
    fun insert(players: DataPlayers)

    @Update
    fun update(players: DataPlayers)

//    @Query("SELECT * from data_players_table WHERE id = :key")
//    fun get(key: Int): DataPlayers?
//
//    @Query("DELETE from data_players_table")
//    fun clear()

}