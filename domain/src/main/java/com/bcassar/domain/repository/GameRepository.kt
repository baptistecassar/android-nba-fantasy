package com.bcassar.domain.repository

import com.bcassar.domain.model.Game
import com.bcassar.domain.model.PlayerGameStats

/**
 * Created by bcassar on 27/10/2022
 */
interface GameRepository {

    suspend fun fetchGames(dayDate: String): List<Game>
    suspend fun fetchPlayersGameStats(dayDate: String): List<PlayerGameStats>

}