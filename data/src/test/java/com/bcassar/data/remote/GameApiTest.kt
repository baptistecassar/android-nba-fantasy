package com.bcassar.data.remote

import com.bcassar.data.remote.api.GamesApi
import com.bcassar.data.testDataModule
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
            modules(testDataModule)
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
        val scoreboardResponse = gamesApi.getAllMovies()
        assertNotNull(scoreboardResponse)
        assertEquals(scoreboardResponse.scoreboard.games.size, 7)
    }
}
