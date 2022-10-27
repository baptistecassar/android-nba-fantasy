package com.bcassar.data.local

import com.bcassar.data.di.testLocalDataModule
import com.bcassar.data.local.dao.GamesDao
import com.bcassar.data.local.dao.TeamsDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DatabaseTest : KoinTest {

    private val database: NbaFantasyDatabase by inject()
    private val teamsDao: TeamsDao by inject()
    private val gamesDao: GamesDao by inject()

    @Before
    fun setUp() {
        startKoin {
            modules(testLocalDataModule)
        }
    }

    @After
    fun tearDown() {
        database.close()
        stopKoin()
    }

    @Test
    fun `should inject my components`() {
        Assert.assertNotNull(database)
        Assert.assertNotNull(teamsDao)
        Assert.assertNotNull(gamesDao)
    }

    @Test
    fun insertTeamSuccess() = runBlocking {
        val entities = listOf(lakers)
        teamsDao.saveTeams(entities)
        val entitiesSaved = teamsDao.getAllTeams()
        Assert.assertEquals(entitiesSaved.size, 1)
        Assert.assertEquals(entities, entitiesSaved)
    }

    @Test
    fun insertGameWithoutTeamsTriggerException() = runBlocking {
        val entities = listOf(game)
        try {
            gamesDao.saveGames(entities)
        } catch (exception: java.lang.Exception) {
            Assert.assertNotNull(exception)
        }
    }

    @Test
    fun insertGameSuccess() = runBlocking {
        val teams = listOf(lakers, blazers)
        teamsDao.saveTeams(teams)
        val entities = listOf(game)
        gamesDao.saveGames(entities)
        val entitiesSaved = gamesDao.getAllGames()
        Assert.assertEquals(entitiesSaved.size, 1)
        Assert.assertEquals(entities, entitiesSaved)
    }

    @Test
    fun getGameWithTeamsSuccess() = runBlocking {
        val teams = listOf(lakers, blazers)
        teamsDao.saveTeams(teams)
        val entities = listOf(game)
        gamesDao.saveGames(entities)
        val entitiesSaved = gamesDao.getGameAndTeams()
        Assert.assertEquals(entitiesSaved.size, 1)
        val gameAndTeams = entitiesSaved.first()
        Assert.assertNotNull(gameAndTeams.gameEntity)
        Assert.assertNotNull(gameAndTeams.awayTeam)
        Assert.assertNotNull(gameAndTeams.homeTeam)
        Assert.assertEquals(gameAndTeams.gameEntity.gameId, game.gameId)
        Assert.assertEquals(gameAndTeams.awayTeam.teamID, blazers.teamID)
        Assert.assertEquals(gameAndTeams.homeTeam.teamID, lakers.teamID)
    }
}
