package com.bcassar.domain.mapper

import com.bcassar.sharedtest.Utils
import com.bcassar.sharedtest.testDate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Created by bcassar on 27/10/2022
 */
class DtoToEntity {
    @Test
    fun `team is mapped correctly`() {
        val scoreboardResponse = Utils.getScoreboardResponse()
        assertNotNull(scoreboardResponse)
        val homeTeam = scoreboardResponse?.scoreboard?.games?.first()?.homeTeam
        assertNotNull(homeTeam)
        val entity = homeTeam?.toEntity()
        assertNotNull(entity)
        assertEquals(homeTeam?.teamID, entity?.teamID)
        assertEquals(homeTeam?.teamName, entity?.teamName)
        assertEquals(homeTeam?.teamCity, entity?.teamCity)
        assertEquals(homeTeam?.teamTricode, entity?.teamTricode)
        assertEquals(homeTeam?.teamSlug, entity?.teamSlug)
        assertEquals(homeTeam?.wins, entity?.wins)
        assertEquals(homeTeam?.losses, entity?.losses)
    }

    @Test
    fun `game is mapped correctly`() {
        val scoreboardResponse = Utils.getScoreboardResponse()
        assertNotNull(scoreboardResponse)
        val game = scoreboardResponse?.scoreboard?.games?.first()
        assertNotNull(game)
        val entity = game?.toEntity(testDate)
        assertNotNull(entity)
        assertEquals(game?.gameId, entity?.gameId)
        assertEquals(game?.gameCode, entity?.gameCode)
        assertEquals(game?.gameStatus, entity?.gameStatus)
        assertEquals(game?.gameStatusText, entity?.gameStatusText)
        assertEquals(game?.period, entity?.period)
        assertEquals(testDate, entity?.gameDay)
        assertEquals(game?.gameClock, entity?.gameClock)
        assertEquals(game?.gameTimeUTC, entity?.gameTimeUTC)
        assertEquals(game?.homeTeam?.teamID, entity?.homeTeamId)
        assertEquals(game?.awayTeam?.teamID, entity?.awayTeamId)
        assertEquals(game?.homeTeam?.score, entity?.homeTeamScore)
        assertEquals(game?.awayTeam?.score, entity?.awayTeamScore)
    }
}