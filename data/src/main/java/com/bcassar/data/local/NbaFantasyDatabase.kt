package com.bcassar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bcassar.data.local.dao.GamesDao
import com.bcassar.data.local.dao.TeamsDao
import com.bcassar.data.local.entity.GameEntity
import com.bcassar.data.local.entity.TeamEntity

/**
 * Created by bcassar on 27/10/2022
 */
@Database(entities = [GameEntity::class, TeamEntity::class], version = 1)
abstract class NbaFantasyDatabase : RoomDatabase() {
    abstract fun gamesDao(): GamesDao
    abstract fun teamsDao(): TeamsDao
}