package com.bcassar.data.remote.model

/**
 * Created by bcassar on 27/10/2022
 */

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScoreboardResponseDto(
    @Json(name = "scoreboard") val scoreboard: ScoreboardDto
)

@JsonClass(generateAdapter = true)
data class ScoreboardDto(
    @Json(name = "gameDate") val gameDate: String,
    @Json(name = "leagueId") val leagueId: String,
    @Json(name = "leagueName") val leagueName: String,
    @Json(name = "games") val games: List<GameDto>
)

@JsonClass(generateAdapter = true)
data class GameDto(
    @Json(name = "gameId") val gameId: String,
    @Json(name = "gameCode") val gameCode: String,
    @Json(name = "gameStatus") val gameStatus: Int,
    @Json(name = "gameStatusText") val gameStatusText: String,
    @Json(name = "period") val period: Long,
    @Json(name = "gameClock") val gameClock: String,
    @Json(name = "gameTimeUTC") val gameTimeUTC: String,
    @Json(name = "gameEt") val gameEt: String,
    @Json(name = "regulationPeriods") val regulationPeriods: Long,
    @Json(name = "seriesGameNumber") val seriesGameNumber: String,
    @Json(name = "seriesText") val seriesText: String,
    @Json(name = "ifNecessary") val ifNecessary: Boolean,
    @Json(name = "homeTeam") val homeTeam: TeamDto,
    @Json(name = "awayTeam") val awayTeam: TeamDto,
)

@JsonClass(generateAdapter = true)
data class TeamDto(
    @Json(name = "teamId") val teamID: Long,
    @Json(name = "teamName") val teamName: String,
    @Json(name = "teamCity") val teamCity: String,
    @Json(name = "teamTricode") val teamTricode: String,
    @Json(name = "teamSlug") val teamSlug: String,
    @Json(name = "wins") val wins: Long,
    @Json(name = "losses") val losses: Long,
    @Json(name = "score") val score: Long,
    @Json(name = "periods") val periods: List<PeriodDto>
)

@JsonClass(generateAdapter = true)
data class PeriodDto(
    @Json(name = "period") val period: Long,
    @Json(name = "score") val score: Long
)