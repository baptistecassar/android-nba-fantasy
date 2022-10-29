package com.bcassar.domain.repository

import com.bcassar.data.local.dao.GamesDao
import com.bcassar.data.local.dao.TeamsDao
import com.bcassar.data.remote.api.GamesApi
import com.bcassar.data.remote.model.GameDto
import com.bcassar.data.remote.model.TeamDto
import com.bcassar.domain.mapper.toDomain
import com.bcassar.domain.mapper.toEntity
import com.bcassar.domain.model.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by bcassar on 27/10/2022
 */
class GameRepositoryImpl constructor(
    private val gamesApi: GamesApi,
    private val teamsDao: TeamsDao,
    private val gamesDao: GamesDao,
) : GameRepository {

    override suspend fun fetchGames(dayDate: String): Flow<List<Game>> {
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
        return gamesDao.getGameAndTeams(dayDate)
            .map { gamesAndTeams ->
                val gameList = gamesAndTeams.map { it.toDomain() }
                gameList
            }
    }

}