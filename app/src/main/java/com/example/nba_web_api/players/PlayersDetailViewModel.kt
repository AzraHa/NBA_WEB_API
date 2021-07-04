package com.example.nba_web_api.players

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nba_web_api.network.dataNBA.DataPlayers

class PlayersDetailViewModel (playersProperty: DataPlayers,
app: Application
) : AndroidViewModel(app) {

    // The internal MutableLiveData for the selected property
    private val _selectedProperty = MutableLiveData<DataPlayers>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<DataPlayers>
    get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = playersProperty
    }


}