package com.example.nba_web_api.teams

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nba_web_api.network.dataNBA.DataTeams

class TeamsDetailViewModelFactory(
    private val teamProperty: DataTeams?,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamsDetailViewModel::class.java)) {
            return teamProperty?.let { TeamsDetailViewModel(it, application) } as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}