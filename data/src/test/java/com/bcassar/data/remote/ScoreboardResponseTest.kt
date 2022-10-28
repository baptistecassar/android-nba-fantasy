package com.bcassar.data.remote

import com.bcassar.data.remote.api.GamesApi
import com.bcassar.data.remote.di.remoteDataModule
import com.bcassar.data.remote.model.ScoreboardResponseDto
import com.bcassar.data.utils.MockResponseFileReader
import com.bcassar.sharedtest.Utils.scoreboardResponseSuccessfulFile
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.MockitoAnnotations

class ScoreboardResponseTest : KoinTest {

    // Lazy inject property
    private val gamesApi: GamesApi by inject()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        startKoin {
            modules(remoteDataModule)
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
    fun `read sample success json file`() {
        val reader = MockResponseFileReader(scoreboardResponseSuccessfulFile)
        assertNotNull(reader.content)
    }

    @Test
    fun `Valid scoreboard response json should parse correctly`() {
        val reader = MockResponseFileReader(scoreboardResponseSuccessfulFile)

        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ScoreboardResponseDto> =
            moshi.adapter(ScoreboardResponseDto::class.java)
        val scoreboardResponse = adapter.fromJson(reader.content)

        assertNotNull(scoreboardResponse)
        assertEquals(scoreboardResponse?.scoreboard?.games?.size, 7)
    }

}
