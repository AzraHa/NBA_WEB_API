package com.example.nba_web_api.teams

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nba_web_api.network.NBAApi
import com.example.nba_web_api.network.dataNBA.DataTeams
import com.example.nba_web_api.network.dataNBA.NBATeams
import kotlinx.coroutines.launch

class TeamsViewModel : ViewModel() {

    private val _properties = MutableLiveData<NBATeams>()

    val properties: LiveData<NBATeams>
        get() = _properties

    // LiveData to handle navigation to the selected property
    private val _navigateToSelectedProperty = MutableLiveData<DataTeams>()
    val navigateToSelectedProperty: LiveData<DataTeams>
        get() = _navigateToSelectedProperty

    init {
        getNBAProperties()
    }

    private fun getNBAProperties() {

        viewModelScope.launch {
            try {
                _properties.value = NBAApi.retrofitService.getTeams()
            } catch (e: Exception) {
                e.message?.let { Log.i("Error: ", it) }
            }
        }
    }

    fun displayPropertyDetails(teamsProperty: DataTeams) {
        _navigateToSelectedProperty.value = teamsProperty
    }

    /**
     * After the navigation has taken place, make sure navigateToSelectedProperty is set to null
     */
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}
