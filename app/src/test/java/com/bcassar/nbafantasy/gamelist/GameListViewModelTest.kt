package com.bcassar.nbafantasy.gamelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bcassar.data.local.model.GameAndTeams
import com.bcassar.domain.mapper.toDomain
import com.bcassar.domain.repository.GameRepository
import com.bcassar.nbafantasy.utils.MainCoroutineRule
import com.bcassar.nbafantasy.utils.getOrAwaitValue
import com.bcassar.sharedtest.blazers
import com.bcassar.sharedtest.game
import com.bcassar.sharedtest.lakers
import io.mockk.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.test.KoinTest

/**
 * Created by bcassar on 27/10/2022
 */
@RunWith(JUnit4::class)
class GameListViewModelTest : KoinTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val gameRepository: GameRepository = mockk()
    private val gameListViewModel by lazy {
        GameListViewModel(gameRepository)
    }

    private val successResource = listOf(
        GameAndTeams(
            gameEntity = game,
            homeTeam = lakers,
            awayTeam = blazers,
        ).toDomain()
    )
    private val errorResource = Throwable("Unauthorised")

    @Test
    fun `check fetching failed`() = runBlocking {
        val gameRepository: GameRepository = mockk()
        coEvery { gameRepository.fetchGames() } throws java.lang.Exception(errorResource)
        gameListViewModel.fetchGameList().join()
        val event = gameListViewModel.gameListEvent.getOrAwaitValue()
        assertNotNull(event)
        assertEquals(true, event.data is GameListEvent.GameListFetchingFailed)
    }

    @Test
    fun `check fetching successful`() = runBlocking {
        coEvery { gameRepository.fetchGames() } returns flowOf(successResource)
        gameListViewModel.fetchGameList().join()
        val event = gameListViewModel.gameListEvent.getOrAwaitValue()
        assertNotNull(event)
        assertEquals(true, event.data is GameListEvent.GameListFetched)
    }
}