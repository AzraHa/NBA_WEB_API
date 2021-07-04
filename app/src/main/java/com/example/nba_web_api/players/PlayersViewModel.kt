package com.example.nba_web_api.players

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nba_web_api.network.NBAApi
import com.example.nba_web_api.network.dataNBA.DataPlayers
import com.example.nba_web_api.network.dataNBA.NBAPlayers
import kotlinx.coroutines.launch

class PlayersViewModel : ViewModel() {

    private val _properties = MutableLiveData<NBAPlayers>()

    val properties: LiveData<NBAPlayers>
        get() = _properties

    // LiveData to handle navigation to the selected property
    private val _navigateToSelectedProperty = MutableLiveData<DataPlayers>()
    val navigateToSelectedProperty: LiveData<DataPlayers>
        get() = _navigateToSelectedProperty
    init {
        getPlayersProperties()
    }

    private fun getPlayersProperties() {

        viewModelScope.launch {
            try {
                _properties.value = NBAApi.retrofitService.getPlayers("")
            } catch (e: Exception) {
                e.message?.let { Log.i("Error: ", it) }
            }
        }
    }
    fun displayPropertyDetails(playersProperty: DataPlayers) {
        _navigateToSelectedProperty.value = playersProperty
    }

    /**
     * After the navigation has taken place, make sure navigateToSelectedProperty is set to null
     */
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}

