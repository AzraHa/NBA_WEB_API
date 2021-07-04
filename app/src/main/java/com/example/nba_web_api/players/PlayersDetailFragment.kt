package com.example.nba_web_api.players

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.nba_web_api.databinding.FragmentPlayersDetailBinding


class PlayersDetailFragment : Fragment() {
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentPlayersDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val playersProperty = PlayersDetailFragmentArgs.fromBundle(arguments!!).playerId
        val viewModelFactory = PlayersDetailViewModelFactory(playersProperty, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(PlayersDetailViewModel::class.java)

        return binding.root
    }


}