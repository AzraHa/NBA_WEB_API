package com.example.nba_web_api.teams

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nba_web_api.R
import com.example.nba_web_api.databinding.FragmentTeamsBinding

class TeamsFragment : Fragment() {

    private val viewModel: TeamsViewModel by lazy {
        ViewModelProvider(this).get(TeamsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentTeamsBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the TeamsViewModel
        binding.viewModel = viewModel

        binding.teamsLinearLayout.adapter = TeamsAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
