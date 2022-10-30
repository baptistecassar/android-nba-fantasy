package com.bcassar.domain.mapper

import androidx.annotation.VisibleForTesting
import com.bcassar.data.local.entity.PlayerGameStatsEntity
import com.bcassar.data.local.entity.TeamEntity
import com.bcassar.data.local.model.GameAndTeams
import com.bcassar.domain.model.Game
import com.bcassar.domain.model.GameStatus
import com.bcassar.domain.model.PlayerGameStats
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

@VisibleForTesting(otherwise = VisibleForTesting.PACKAGE_PRIVATE)
fun PlayerGameStatsEntity.toDomain() =
    PlayerGameStats(
        playerId = this.playerId,
        playerName = this.playerName,
        startPosition = this.startPosition,
        fieldGoalMarked = this.fgm,
        fieldGoalAttempted = this.fga,
        fieldGoal3Marked = this.fg3m,
        fieldGoal3Attempted = this.fg3a,
        freeThrowMarked = this.ftm,
        freeThrowAttempted = this.fta,
        rebounds = this.reb,
        assists = this.ast,
        steals = this.stl,
        blocks = this.blk,
        turnovers = this.to,
        fouls = this.pf,
        points = this.pts,
    )