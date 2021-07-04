package com.example.nba_web_api.teams

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nba_web_api.network.dataNBA.DataTeams

class TeamsDetailViewModel( teamProperty: DataTeams,
                            app: Application) : AndroidViewModel(app) {

    // The internal MutableLiveData for the selected property
    private val _selectedProperty = MutableLiveData<DataTeams>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<DataTeams>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = teamProperty
    }


}
