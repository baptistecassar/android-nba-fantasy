package com.bcassar.data.remote.api

import com.bcassar.data.remote.model.ScoreboardResponseDto
import retrofit2.http.GET

/**
 * Created by bcassar on 26/10/2022
 */
interface GamesApi {

    @GET("stats/scoreboardv3?GameDate=2022-10-23&LeagueID=00")
    suspend fun getScoreboard(): ScoreboardResponseDto
}