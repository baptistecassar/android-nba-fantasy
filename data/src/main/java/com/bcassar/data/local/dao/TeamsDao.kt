package com.bcassar.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bcassar.data.local.entity.TeamEntity

/**
 * Created by bcassar on 27/10/2022
 */
@Dao
interface TeamsDao {

    /**
     * Save teams
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTeams(entities: List<TeamEntity>)

    @Query("SELECT * FROM team")
    suspend fun getAllTeams(): List<TeamEntity>

}