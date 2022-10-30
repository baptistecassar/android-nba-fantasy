package com.bcassar.domain.mapper

import com.bcassar.data.local.entity.GameEntity
import com.bcassar.data.local.entity.PlayerGameStatsEntity
import com.bcassar.data.local.entity.TeamEntity
import com.bcassar.data.remote.model.GameDto
import com.bcassar.data.remote.model.TeamDto

/**
 * Created by bcassar on 27/10/2022
 */

internal fun TeamDto.toEntity() =
    TeamEntity(
        teamID = this.teamID,
        teamName = this.teamName,
        teamCity = this.teamCity,
        teamTricode = this.teamTricode,
        teamSlug = this.teamSlug,
        wins = this.wins,
        losses = this.losses,
    )

internal fun GameDto.toEntity(dayDate: String) =
    GameEntity(
        gameId = this.gameId,
        gameCode = this.gameCode,
        gameStatus = this.gameStatus,
        gameStatusText = this.gameStatusText,
        period = this.period,
        gameClock = this.gameClock,
        gameTimeUTC = this.gameTimeUTC,
        gameDay = dayDate,
        homeTeamId = this.homeTeam.teamID,
        awayTeamId = this.awayTeam.teamID,
        homeTeamScore = this.homeTeam.score,
        awayTeamScore = this.awayTeam.score,
    )

internal fun List<String>.toEntity(): PlayerGameStatsEntity? {
    if (this.size != 29) return null
    try {
        return PlayerGameStatsEntity(
            gameId = this[0],
            teamId = this[1].toLong(),
            teamAbbreviation = this[2],
            teamCity = this[3],
            playerId = this[4].toLong(),
            playerName = this[5],
            nickname = this[6],
            startPosition = this[7],
            comment = this[8],
            min = this[9],
            fgm = this[10].toInt(),
            fga = this[11].toInt(),
            fgPct = this[12].toDouble(),
            fg3m = this[13].toInt(),
            fg3a = this[14].toInt(),
            fg3Pct = this[15].toDouble(),
            ftm = this[16].toInt(),
            fta = this[17].toInt(),
            ftPct = this[18].toDouble(),
            oreb = this[19].toInt(),
            dreb = this[20].toInt(),
            reb = this[21].toInt(),
            ast = this[22].toInt(),
            stl = this[23].toInt(),
            blk = this[24].toInt(),
            to = this[25].toInt(),
            pf = this[26].toInt(),
            pts = this[27].toInt(),
            plusMinus = this[28].toDouble().toInt(),
        )
    } catch (exception: java.lang.Exception) {
        return null
    }
}