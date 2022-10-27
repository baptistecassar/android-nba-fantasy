package com.bcassar.data.local

import com.bcassar.data.local.entity.GameEntity
import com.bcassar.data.local.entity.TeamEntity

/**
 * Created by bcassar on 27/10/2022
 */
val lakers = TeamEntity(
    teamID = 1610612747,
    teamName = "Lakers",
    teamCity = "Los Angeles",
    teamTricode = "LAL",
    teamSlug = "lakers",
    wins = 0,
    losses = 3,
)

val blazers = TeamEntity(
    teamID = 1610612757,
    teamName = "Trail Blazers",
    teamCity = "Portland",
    teamTricode = "POR",
    teamSlug = "blazers",
    wins = 3,
    losses = 0,
)

val game = GameEntity(
    gameId = "0022200037",
    gameCode = "20221023/PORLAL",
    gameStatus = 3,
    gameStatusText = "Final",
    period = 4,
    gameClock = "",
    gameTimeUTC = "2022-10-23T19:30:00Z",
    homeTeamId = 1610612747,
    awayTeamId = 1610612757,
    homeTeamScore = 104,
    awayTeamScore = 106,
)