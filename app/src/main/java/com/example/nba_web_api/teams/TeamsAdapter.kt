package com.example.nba_web_api.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nba_web_api.databinding.TeamsListItemBinding
import com.example.nba_web_api.network.dataNBA.DataTeams

class TeamsAdapter : ListAdapter<DataTeams, TeamsAdapter.NBAPropertyViewHolder>(DiffCallback) {
    class NBAPropertyViewHolder(private var binding: TeamsListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(NBATeamsProperty: DataTeams) {
            binding.property = NBATeamsProperty
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<DataTeams>() {
        override fun areItemsTheSame(oldItem: DataTeams, newItem: DataTeams): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DataTeams, newItem: DataTeams): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NBAPropertyViewHolder {
        return NBAPropertyViewHolder(TeamsListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: NBAPropertyViewHolder, position: Int) {
        val nBATeamsProperty = getItem(position)
        holder.bind(nBATeamsProperty)
    }

}
