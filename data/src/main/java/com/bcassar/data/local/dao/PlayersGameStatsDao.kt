package com.bcassar.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bcassar.data.local.entity.PlayerGameStatsEntity

/**
 * Created by bcassar on 30/10/2022
 */
@Dao
interface PlayersGameStatsDao {

    /**
     * Save teams
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePlayersGameStats(entities: List<PlayerGameStatsEntity>)

    @Query("SELECT * FROM player_game_stats")
    suspend fun getAllPlayerGameStats(): List<PlayerGameStatsEntity>

    @Query("SELECT * FROM player_game_stats WHERE game_id IN (:gameIds) ")
    suspend fun getPlayerGameStatsFromGames(gameIds: List<String>): List<PlayerGameStatsEntity>
}