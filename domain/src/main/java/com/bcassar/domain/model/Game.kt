package com.bcassar.domain.model

import java.util.*

/**
 * Created by bcassar on 27/10/2022
 */
data class Game(
    val gameId: String,
    val gameCode: String,
    val gameStatus: Long,
    val gameStatusText: String,
    val period: Long,
    val gameClock: String,
    val gameTimeUTC: Date,
    val honeTeam: Team,
    val awayTeam: Team,
    val homeTeamScore: Long,
    val awayTeamScore: Long,
)