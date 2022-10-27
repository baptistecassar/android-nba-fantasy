package com.bcassar.domain.mapper

import com.bcassar.data.local.model.GameAndTeams
import com.bcassar.sharedtest.blazers
import com.bcassar.sharedtest.game
import com.bcassar.sharedtest.lakers
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Created by bcassar on 27/10/2022
 */
class EntityToDomain {

    @Test
    fun `team entity is mapped correctly`() {
        val team = lakers.toDomain()
        assertNotNull(team)
        assertEquals(lakers.teamID, team.teamID)
        assertEquals(lakers.teamName, team.teamName)
        assertEquals(lakers.teamCity, team.teamCity)
        assertEquals(lakers.teamTricode, team.teamTricode)
        assertEquals(lakers.teamSlug, team.teamSlug)
        assertEquals(lakers.wins, team.wins)
        assertEquals(lakers.losses, team.losses)
    }

    @Test
    fun `game entity is mapped correctly`() {
        val gameDomain = GameAndTeams(
            gameEntity = game,
            homeTeam = lakers,
            awayTeam = blazers,
        ).toDomain()
        assertNotNull(gameDomain)
        assertEquals(lakers.teamID, gameDomain.honeTeam.teamID)
        assertEquals(lakers.teamName, gameDomain.honeTeam.teamName)
        assertEquals(lakers.teamCity, gameDomain.honeTeam.teamCity)
        assertEquals(lakers.teamTricode, gameDomain.honeTeam.teamTricode)
        assertEquals(lakers.teamSlug, gameDomain.honeTeam.teamSlug)
        assertEquals(lakers.wins, gameDomain.honeTeam.wins)
        assertEquals(lakers.losses, gameDomain.honeTeam.losses)

        assertEquals(game.gameId, gameDomain.gameId)
        assertEquals(game.gameCode, gameDomain.gameCode)
        assertEquals(game.gameStatus, gameDomain.gameStatus)
        assertEquals(game.gameStatusText, gameDomain.gameStatusText)
        assertEquals(game.period, gameDomain.period)
        assertEquals(game.gameClock, gameDomain.gameClock)
        assertEquals(game.homeTeamScore, gameDomain.homeTeamScore)
        assertEquals(game.awayTeamScore, gameDomain.awayTeamScore)
    }

}