package com.example.nba_web_api

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nba_web_api.network.dataNBA.DataTeams
import com.example.nba_web_api.teams.TeamsAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DataTeams>?) {
    val adapter = recyclerView.adapter as TeamsAdapter
    adapter.submitList(data)
}

//@BindingAdapter("playerListData")
//fun bindRecyclerViewP(recyclerView: RecyclerView, data: List<DataPlayers>?) {
//    val adapter = recyclerView.adapter as PlayersAdapter
//    adapter.submitList(data)
//}
