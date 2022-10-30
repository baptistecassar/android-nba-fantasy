package com.bcassar.nbafantasy.playerstatslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bcassar.domain.model.PlayerGameStats
import com.bcassar.nbafantasy.databinding.ItemPlayerGameStatsBinding

/**
 * Created by bcassar on 28/10/2022
 */
class PlayerGameStatsAdapter :
    ListAdapter<PlayerGameStats, PlayerGameStatsAdapter.PlayerGameStatsViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PlayerGameStats>() {
            override fun areItemsTheSame(
                oldItem: PlayerGameStats,
                newItem: PlayerGameStats
            ): Boolean {
                return oldItem.playerId == newItem.playerId
            }

            override fun areContentsTheSame(
                oldItem: PlayerGameStats,
                newItem: PlayerGameStats
            ): Boolean {
                return oldItem.fantasyPoints == newItem.fantasyPoints
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerGameStatsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPlayerGameStatsBinding.inflate(inflater, parent, false)
        return PlayerGameStatsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerGameStatsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class PlayerGameStatsViewHolder(private val binding: ItemPlayerGameStatsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(playerGameStats: PlayerGameStats) {
            binding.playerName.text = playerGameStats.playerName
            binding.playerScore.text = playerGameStats.fantasyPoints.toString()
        }
    }

}