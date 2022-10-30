package com.bcassar.domain.model

/**
 * Created by bcassar on 30/10/2022
 */
data class PlayerGameStats(
    val playerId: Long,
    val playerName: String,
    val startPosition: String,
    val fieldGoalMarked: Int,
    val fieldGoalAttempted: Int,
    val fieldGoal3Marked: Int,
    val fieldGoal3Attempted: Int,
    val freeThrowMarked: Int,
    val freeThrowAttempted: Int,
    val rebounds: Int,
    val assists: Int,
    val steals: Int,
    val blocks: Int,
    val turnovers: Int,
    val fouls: Int,
    val points: Int,
) {
    private val fantasyBonusPoints =
        points + rebounds + assists + steals + blocks + fieldGoalMarked + fieldGoal3Marked + freeThrowMarked
    private val fantasyMalusPoints =
        turnovers + (fieldGoalAttempted - fieldGoalMarked) + (fieldGoal3Attempted - fieldGoal3Marked) + (freeThrowAttempted - freeThrowMarked)
    val fantasyPoints = fantasyBonusPoints - fantasyMalusPoints
}
