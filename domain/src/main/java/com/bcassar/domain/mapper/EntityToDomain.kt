package com.bcassar.domain.mapper

import androidx.annotation.VisibleForTesting
import com.bcassar.data.local.entity.TeamEntity
import com.bcassar.data.local.model.GameAndTeams
import com.bcassar.domain.model.Game
import com.bcassar.domain.model.GameStatus
import com.bcassar.domain.model.Team
import com.bcassar.domain.utils.toDate

/**
 * Created by bcassar on 27/10/2022
 */

@VisibleForTesting(otherwise = VisibleForTesting.PACKAGE_PRIVATE)
fun GameAndTeams.toDomain() =
    Game(
        gameId = this.gameEntity.gameId,
        gameCode = this.gameEntity.gameCode,
        gameStatus = GameStatus.fromInt(this.gameEntity.gameStatus),
        gameStatusText = this.gameEntity.gameStatusText,
        period = this.gameEntity.period,
        gameClock = this.gameEntity.gameClock,
        gameTimeUTC = this.gameEntity.gameTimeUTC.toDate(),
        homeTeam = this.homeTeam.toDomain(),
        awayTeam = this.awayTeam.toDomain(),
        homeTeamScore = this.gameEntity.homeTeamScore,
        awayTeamScore = this.gameEntity.awayTeamScore,
    )

internal fun TeamEntity.toDomain() =
    Team(
        teamID = this.teamID,
        teamName = this.teamName,
        teamCity = this.teamCity,
        teamTricode = this.teamTricode,
        teamSlug = this.teamSlug,
        wins = this.wins,
        losses = this.losses,
    )