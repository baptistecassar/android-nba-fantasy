package com.bcassar.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by bcassar on 27/10/2022
 */
@Entity(
    tableName = "team",
)
data class TeamEntity(
    @PrimaryKey @ColumnInfo(name = "teamId") val teamID: Long,
    @ColumnInfo(name = "teamName") val teamName: String,
    @ColumnInfo(name = "teamCity") val teamCity: String,
    @ColumnInfo(name = "teamTricode") val teamTricode: String,
    @ColumnInfo(name = "teamSlug") val teamSlug: String,
    @ColumnInfo(name = "wins") val wins: Long,
    @ColumnInfo(name = "losses") val losses: Long,
)