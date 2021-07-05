package com.example.nba_web_api.database.nbaTeams

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nba_web_api.network.dataNBA.NBATeams

@Database(entities = [NBATeams::class], version = 1)
abstract class NBATeamsDatabase : RoomDatabase() {
    abstract val nbaTeamsDAO: NBATeamsDAO
    companion object{
        @Volatile
        private var INSTANCE: NBATeamsDatabase? = null
        fun getInstance(context: Context): NBATeamsDatabase {
            synchronized(this) {
                var instance = NBATeamsDatabase.INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        NBATeamsDatabase::class.java,
                        "Player_team_database").fallbackToDestructiveMigration().build()
                    NBATeamsDatabase.INSTANCE = instance
                }
                return instance
            }
        }
    }
}