package com.example.nba_web_api.database.nbaPlayers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nba_web_api.network.dataNBA.Convertors
import com.example.nba_web_api.network.dataNBA.DataPlayers

@Database(entities = [DataPlayers::class], version = 1)
@TypeConverters(Convertors::class)
abstract class PlayersDatabase : RoomDatabase() {
    abstract val dataPlayersDao: DataPlayersDAO
    companion object {
        @Volatile
        private var INSTANCE: PlayersDatabase? = null
        fun getInstance(context: Context): PlayersDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        PlayersDatabase::class.java,
                        "Players_database").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}