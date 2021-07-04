package com.example.nba_web_api.players

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nba_web_api.network.dataNBA.DataPlayers


class PlayersDetailViewModelFactory(
    private val teamProperty: DataPlayers?,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayersDetailViewModel::class.java)) {
            return teamProperty?.let { PlayersDetailViewModel(it, application) } as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}