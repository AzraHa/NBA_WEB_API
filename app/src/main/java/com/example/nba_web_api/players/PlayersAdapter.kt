package com.example.nba_web_api.players

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nba_web_api.databinding.PlayersListItemBinding
import com.example.nba_web_api.network.dataNBA.DataPlayers
import com.example.nba_web_api.network.dataNBA.DataTeams
import com.example.nba_web_api.teams.TeamsAdapter


class PlayersAdapter( private val onClickListener: PlayersAdapter.OnClickListener) : ListAdapter<DataPlayers, PlayersAdapter.NBAPlayerViewHolder>(DiffCallback) {
    class NBAPlayerViewHolder(private var binding: PlayersListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(NBAPlayersProperty: DataPlayers) {
            binding.property = NBAPlayersProperty
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<DataPlayers>() {
        override fun areItemsTheSame(oldItem: DataPlayers, newItem: DataPlayers): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DataPlayers, newItem: DataPlayers): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NBAPlayerViewHolder {
        return NBAPlayerViewHolder(PlayersListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: NBAPlayerViewHolder, position: Int) {
        val nBAPlayersProperty = getItem(position)
        holder.bind(nBAPlayersProperty)
    }
    class OnClickListener(val clickListener: (playersProperty: DataPlayers) -> Unit) {
        fun onClick(playersProperty: DataPlayers) = clickListener(playersProperty)
    }

}
