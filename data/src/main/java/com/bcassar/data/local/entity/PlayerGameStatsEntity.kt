package com.bcassar.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

/**
 * Created by bcassar on 30/10/2022
 */
@Entity(
    tableName = "player_game_stats",
    foreignKeys = [ForeignKey(
        entity = TeamEntity::class,
        childColumns = ["team_id"],
        parentColumns = ["teamId"]
    ), ForeignKey(
        entity = GameEntity::class,
        childColumns = ["game_id"],
        parentColumns = ["gameId"]
    )],
    primaryKeys = ["game_id", "team_id", "player_id"]
)
data class PlayerGameStatsEntity(
    @ColumnInfo(name = "game_id") val gameId: String,
    @ColumnInfo(name = "team_id") val teamId: Long,
    @ColumnInfo(name = "team_abbreviation") val teamAbbreviation: String,
    @ColumnInfo(name = "team_city") val teamCity: String,
    @ColumnInfo(name = "player_id") val playerId: Long,
    @ColumnInfo(name = "player_name") val playerName: String,
    @ColumnInfo(name = "nickname") val nickname: String,
    @ColumnInfo(name = "start_position") val startPosition: String,
    @ColumnInfo(name = "comment") val comment: String,
    @ColumnInfo(name = "min") val min: String,
    @ColumnInfo(name = "fgm") val fgm: Int,
    @ColumnInfo(name = "fga") val fga: Int,
    @ColumnInfo(name = "fg_pct") val fgPct: Double,
    @ColumnInfo(name = "fg3m") val fg3m: Int,
    @ColumnInfo(name = "fg3a") val fg3a: Int,
    @ColumnInfo(name = "fg3_pct") val fg3Pct: Double,
    @ColumnInfo(name = "ftm") val ftm: Int,
    @ColumnInfo(name = "fta") val fta: Int,
    @ColumnInfo(name = "ft_pct") val ftPct: Double,
    @ColumnInfo(name = "oreb") val oreb: Int,
    @ColumnInfo(name = "dreb") val dreb: Int,
    @ColumnInfo(name = "reb") val reb: Int,
    @ColumnInfo(name = "ast") val ast: Int,
    @ColumnInfo(name = "stl") val stl: Int,
    @ColumnInfo(name = "blk") val blk: Int,
    @ColumnInfo(name = "to") val to: Int,
    @ColumnInfo(name = "pf") val pf: Int,
    @ColumnInfo(name = "pts") val pts: Int,
    @ColumnInfo(name = "plus_minus") val plusMinus: Int,
)