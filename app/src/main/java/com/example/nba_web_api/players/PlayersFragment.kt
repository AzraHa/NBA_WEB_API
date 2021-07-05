package com.example.nba_web_api.players

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nba_web_api.R
import com.example.nba_web_api.databinding.FragmentPlayersBinding
import com.example.nba_web_api.teams.TeamsAdapter
import com.example.nba_web_api.teams.TeamsFragmentDirections

class PlayersFragment : Fragment() {

    private val viewModel: PlayersViewModel by lazy {
        ViewModelProvider(this).get(PlayersViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentPlayersBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the TeamsViewModel
        binding.viewModelPlayers = viewModel

        binding.playersLinearLayout.adapter = PlayersAdapter(PlayersAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })

        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                // Must find the NavController from the Fragment
                this.findNavController().navigate(PlayersFragmentDirections.actionPlayersFragmentToPlayersDetailFragment(it))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                viewModel.displayPropertyDetailsComplete()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}