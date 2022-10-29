package com.bcassar.domain.mapper

import com.bcassar.data.local.entity.GameEntity
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