package com.example.nba_web_api.teams

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nba_web_api.databinding.FragmentTeamsDetailBinding

class TeamsDetailFragment: Fragment() {

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentTeamsDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val teamsProperty = TeamsDetailFragmentArgs.fromBundle(arguments!!).teamId
        val viewModelFactory = TeamsDetailViewModelFactory(teamsProperty, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(TeamsDetailViewModel::class.java)

        return binding.root
    }
}