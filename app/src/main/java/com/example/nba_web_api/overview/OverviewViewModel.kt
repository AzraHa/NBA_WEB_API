package com.example.nba_web_api.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nba_web_api.network.NBAApi
import com.example.nba_web_api.network.dataNBA.NBATeams
import kotlinx.coroutines.launch


/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {


    private val _properties = MutableLiveData<NBATeams>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val properties: LiveData<NBATeams>
        get() = _properties
    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getNBAProperties()
    }

    /**
     * Sets the value of the response LiveData to the Mars API status or the successful number of
     * Mars properties retrieved.
     */
    private fun getNBAProperties() {

        viewModelScope.launch {
            try {
                _properties.value = NBAApi.retrofitService.getTeams()
            } catch (e: Exception) {
            }
        }
    }
}
