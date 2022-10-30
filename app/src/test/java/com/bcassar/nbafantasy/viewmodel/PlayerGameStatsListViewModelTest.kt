package com.bcassar.nbafantasy.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bcassar.domain.mapper.toDomain
import com.bcassar.domain.repository.GameRepository
import com.bcassar.nbafantasy.playerstatslist.PlayerGameStatsListEvent
import com.bcassar.nbafantasy.playerstatslist.PlayerGameStatsListViewModel
import com.bcassar.nbafantasy.utils.MainCoroutineRule
import com.bcassar.nbafantasy.utils.getOrAwaitValue
import com.bcassar.sharedtest.*
import io.mockk.*
import kotlinx.coroutines.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.test.KoinTest
import kotlin.test.assertTrue

/**
 * Created by bcassar on 27/10/2022
 */
@RunWith(JUnit4::class)
class PlayerGameStatsListViewModelTest : KoinTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val gameRepository: GameRepository = mockk()
    private val playerGameStatsListViewModel by lazy {
        PlayerGameStatsListViewModel(testDate, gameRepository)
    }

    private val successResource = listOf(playerGameStats.toDomain())
    private val errorResource = Throwable("Unauthorised")

    @Test
    fun `check fetching failed`() = runBlocking {
        val gameRepository: GameRepository = mockk()
        coEvery { gameRepository.fetchPlayersGameStats(testDate) } throws java.lang.Exception(
            errorResource
        )
        playerGameStatsListViewModel.fetchPlayerGameStatsList().join()
        val event = playerGameStatsListViewModel.playerGameStatsListEvent.getOrAwaitValue()
        assertNotNull(event)
        assertEquals(true, event.data is PlayerGameStatsListEvent.PlayerGameStatsListFetchingFailed)
    }

    @Test
    fun `check fetching successful`() = runBlocking {
        coEvery { gameRepository.fetchPlayersGameStats(testDate) } returns successResource
        playerGameStatsListViewModel.fetchPlayerGameStatsList().join()
        val event = playerGameStatsListViewModel.playerGameStatsListEvent.getOrAwaitValue()
        assertNotNull(event)
        assertEquals(true, event.data is PlayerGameStatsListEvent.PlayerGameStatsListFetched)
        assertTrue((event.data as PlayerGameStatsListEvent.PlayerGameStatsListFetched).playerGameStatsList.isNotEmpty())
    }
}