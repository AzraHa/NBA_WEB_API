package com.example.nba_web_api.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nba_web_api.network.NBAApi
import com.example.nba_web_api.network.dataNBA.NBATeams
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

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
        NBAApi.retrofitService.getTeams().enqueue(
            object: Callback<NBATeams> {

                override fun onResponse(call: Call<NBATeams>, response: Response<NBATeams>) {
                    _response.value = response.body().toString()
                }

                override fun onFailure(call: Call<NBATeams>, t: Throwable) {
                    _response.value =
                        "Error: " + t.message
                }
            })
    }
}