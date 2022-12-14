package com.bcassar.data.remote

import com.bcassar.data.remote.api.GamesApi
import com.bcassar.sharedtest.game
import com.bcassar.sharedtest.testDate
import com.bcassar.sharedtest.testRemoteDataModule
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GameApiTest : KoinTest {

    // Lazy inject property
    private val gamesApi: GamesApi by inject()

    @Before
    fun setUp() {
        startKoin {
            modules(testRemoteDataModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `should inject my components`() {
        assertNotNull(gamesApi)
    }

    @Test
    fun `Valid scoreboard response json should parse correctly`() = runBlocking {
        val scoreboardResponse = gamesApi.getScoreboard(testDate)
        assertNotNull(scoreboardResponse)
        assertEquals(scoreboardResponse.scoreboard.games.size, 7)
    }

    @Test
    fun `Valid boxscore response json should parse correctly`() = runBlocking {
        val boxscoreResponse = gamesApi.getBoxscore(game.gameId)
        assertNotNull(boxscoreResponse)
        assertEquals(3, boxscoreResponse.resultSets.size)
    }
}
