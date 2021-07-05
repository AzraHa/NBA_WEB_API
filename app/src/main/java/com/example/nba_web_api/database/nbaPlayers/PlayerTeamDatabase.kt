package com.example.nba_web_api.database.nbaPlayers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nba_web_api.network.dataNBA.Convertors
import com.example.nba_web_api.network.dataNBA.PlayerTeam

@Database(entities = [PlayerTeam::class], version = 1)
@TypeConverters(Convertors::class)
abstract class PlayerTeamDatabase : RoomDatabase() {
    abstract val playerTeamDao: PlayerTeamDAO
    companion object {
        @Volatile
        private var INSTANCE: PlayerTeamDatabase? = null
        fun getInstance(context: Context): PlayerTeamDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        PlayerTeamDatabase::class.java,
                        "player_team_database").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}