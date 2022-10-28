package com.bcassar.nbafantasy.gamelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bcassar.domain.model.Game
import com.bcassar.nbafantasy.databinding.ItemGameBinding

/**
 * Created by bcassar on 28/10/2022
 */
class GameAdapter : ListAdapter<Game, GameAdapter.GameViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Game>() {
            override fun areItemsTheSame(
                oldItem: Game,
                newItem: Game
            ): Boolean {
                return oldItem.gameId == newItem.gameId
            }

            override fun areContentsTheSame(
                oldItem: Game,
                newItem: Game
            ): Boolean {
                return oldItem.homeTeamScore == newItem.awayTeamScore &&
                        oldItem.gameStatus == newItem.gameStatus
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGameBinding.inflate(inflater, parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class GameViewHolder(private val binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Game) {
            binding.awayTeamName.text = game.awayTeam.teamTricode
            binding.homeTeamName.text = game.homeTeam.teamTricode
            binding.score.text = "${game.homeTeamScore} - ${game.awayTeamScore}"
        }
    }

}