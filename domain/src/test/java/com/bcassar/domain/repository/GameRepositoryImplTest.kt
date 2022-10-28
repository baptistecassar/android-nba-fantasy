package com.bcassar.domain.repository

import com.bcassar.domain.di.domainModule
import com.bcassar.sharedtest.testLocalDataModule
import com.bcassar.sharedtest.testRemoteDataModule
import kotlinx.coroutines.flow.first
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
import org.robolectric.RobolectricTestRunner

/**
 * Created by bcassar on 27/10/2022
 */
@RunWith(RobolectricTestRunner::class)
class GameRepositoryImplTest : KoinTest {

    // Lazy inject property
    private val gameRepository: GameRepository by inject()

    @Before
    fun setUp() {
        startKoin {
            modules(testRemoteDataModule, testLocalDataModule, domainModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `should inject my components`() {
        assertNotNull(gameRepository)
    }

    @Test
    fun `should fetch and saves scoreboard`() = runBlocking {
        val gameList = gameRepository.fetchGames().first()
        assertNotNull(gameList)
        assertEquals(gameList.size, 7)
    }

}