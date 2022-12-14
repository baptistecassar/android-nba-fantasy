package com.bcassar.data.local.dao

import androidx.room.*
import com.bcassar.data.local.entity.GameEntity
import com.bcassar.data.local.model.GameAndTeams

/**
 * Created by bcassar on 27/10/2022
 */
@Dao
interface GamesDao {

    /**
     * Save games
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGames(entities: List<GameEntity>)

    @Query("SELECT * FROM game")
    suspend fun getAllGames(): List<GameEntity>

    @Transaction
    @Query("SELECT * FROM game WHERE gameDay = :dayDate")
    fun getGameAndTeams(dayDate: String): List<GameAndTeams>
}