package com.example.nba_web_api

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nba_web_api.network.dataNBA.DataTeams
import com.example.nba_web_api.overview.TeamsAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DataTeams>?) {
    val adapter = recyclerView.adapter as TeamsAdapter
    adapter.submitList(data)
}

