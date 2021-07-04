package com.example.nba_web_api.teams

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nba_web_api.network.NBAApi
import com.example.nba_web_api.network.dataNBA.NBATeams
import kotlinx.coroutines.launch

class TeamsViewModel : ViewModel() {

    private val _properties = MutableLiveData<NBATeams>()

    val properties: LiveData<NBATeams>
        get() = _properties

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
}
