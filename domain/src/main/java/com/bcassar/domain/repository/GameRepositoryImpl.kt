package com.bcassar.domain.repository

import com.bcassar.data.local.dao.GamesDao
import com.bcassar.data.local.dao.PlayersGameStatsDao
import com.bcassar.data.local.dao.TeamsDao
import com.bcassar.data.remote.api.GamesApi
import com.bcassar.data.remote.model.GameDto
import com.bcassar.data.remote.model.TeamDto
import com.bcassar.domain.mapper.toDomain
import com.bcassar.domain.mapper.toEntity
import com.bcassar.domain.model.Game
import com.bcassar.domain.model.GameStatus
import com.bcassar.domain.model.PlayerGameStats
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

/**
 * Created by bcassar on 27/10/2022
 */
class GameRepositoryImpl constructor(
    private val gamesApi: GamesApi,
    private val teamsDao: TeamsDao,
    private val gamesDao: GamesDao,
    private val playersGameStatsDao: PlayersGameStatsDao,
) : GameRepository {

    override suspend fun fetchGames(dayDate: String): List<Game> {
        val savedGames = gamesDao.getGameAndTeams(dayDate).map { it.toDomain() }
        val allGamesFinished = savedGames.all { it.gameStatus == GameStatus.FINISHED }
        return if (savedGames.isEmpty() || !allGamesFinished) {
            fetchAndSaveScoreboard(dayDate)
            gamesDao.getGameAndTeams(dayDate).map { it.toDomain() }
        } else {
            savedGames
        }
    }

    private suspend fun fetchAndSaveScoreboard(dayDate: String) {
        val scoreboardResponse = gamesApi.getScoreboard(dayDate)
        val teams = mutableListOf<TeamDto>()
        val games = mutableListOf<GameDto>()
        scoreboardResponse.scoreboard.games.forEach { gameDto ->
            games.add(gameDto)
            teams.add(gameDto.homeTeam)
            teams.add(gameDto.awayTeam)
        }
        teamsDao.saveTeams(teams.map { it.toEntity() })
        gamesDao.saveGames(games.map { it.toEntity(dayDate) })
    }

    override suspend fun fetchPlayersGameStats(dayDate: String): List<PlayerGameStats> =
        withContext(Dispatchers.Default) {
            val gameIds = fetchGames(dayDate).map { it.gameId }
            val entities = gameIds.map { gameId ->
                async {
                    gamesApi.getBoxscore(gameId).resultSets.first { it.name == "PlayerStats" }.rowSet
                        .mapNotNull { rowSet ->
                            rowSet.toEntity()
                        }
                }
            }.awaitAll().flatten()
            playersGameStatsDao.savePlayersGameStats(entities)
            return@withContext playersGameStatsDao.getPlayerGameStatsFromGames(gameIds)
                .map { it.toDomain() }
        }

}