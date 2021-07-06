package com.example.nba_web_api.teams

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nba_web_api.R
import com.example.nba_web_api.databinding.FragmentTeamsDetailBinding

class TeamsDetailFragment : Fragment() {

    private var teamName: String = ""
    private var teamCity: String = ""
    private var teamFullName: String = ""


    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentTeamsDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this


        val teamsProperty = TeamsDetailFragmentArgs.fromBundle(arguments!!).teamId
        val viewModelFactory = TeamsDetailViewModelFactory(teamsProperty, application)
        binding.viewModelTeamsDetail = ViewModelProvider(
            this, viewModelFactory
        ).get(TeamsDetailViewModel::class.java)

        teamName = teamsProperty.name.toString()
        teamCity = teamsProperty.city.toString()
        teamFullName = teamsProperty.full_name.toString()

        setHasOptionsMenu(true)

        return binding.root
    }

    @SuppressLint("StringFormatInvalid")
    fun getShareIntent(): Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(
                Intent.EXTRA_TEXT,
                getString(R.string.share_team_text, teamName , teamCity, teamFullName)
            )
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}