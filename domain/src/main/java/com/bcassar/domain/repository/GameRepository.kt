package com.bcassar.domain.repository

import com.bcassar.domain.model.Game

/**
 * Created by bcassar on 27/10/2022
 */
interface GameRepository {

    suspend fun fetchGames(dayDate: String): List<Game>

}