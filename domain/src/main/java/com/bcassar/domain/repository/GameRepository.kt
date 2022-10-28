package com.bcassar.domain.repository

import com.bcassar.domain.model.Game
import kotlinx.coroutines.flow.Flow

/**
 * Created by bcassar on 27/10/2022
 */
interface GameRepository {

    suspend fun fetchGames(dayDate: String): Flow<List<Game>>

}