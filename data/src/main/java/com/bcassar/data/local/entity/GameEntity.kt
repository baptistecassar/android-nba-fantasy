package com.bcassar.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Created by bcassar on 27/10/2022
 */
@Entity(
    tableName = "game",
    foreignKeys = [ForeignKey(
        entity = TeamEntity::class,
        childColumns = ["homeTeamId"],
        parentColumns = ["teamId"]
    ), ForeignKey(
        entity = TeamEntity::class,
        childColumns = ["awayTeamId"],
        parentColumns = ["teamId"]
    )]
)
data class GameEntity(
    @PrimaryKey @ColumnInfo(name = "gameId") val gameId: String,
    @ColumnInfo(name = "gameCode") val gameCode: String,
    @ColumnInfo(name = "gameStatus") val gameStatus: Long,
    @ColumnInfo(name = "gameStatusText") val gameStatusText: String,
    @ColumnInfo(name = "period") val period: Long,
    @ColumnInfo(name = "gameClock") val gameClock: String,
    @ColumnInfo(name = "gameTimeUTC") val gameTimeUTC: String,
    @ColumnInfo(name = "homeTeamId") val homeTeamId: Long,
    @ColumnInfo(name = "awayTeamId") val awayTeamId: Long,
    @ColumnInfo(name = "homeTeamScore") val homeTeamScore: Long,
    @ColumnInfo(name = "awayTeamScore") val awayTeamScore: Long,
)