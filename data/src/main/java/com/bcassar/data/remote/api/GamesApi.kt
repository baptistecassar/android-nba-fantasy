package com.bcassar.data.remote.api

import com.bcassar.data.remote.model.ScoreboardResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by bcassar on 26/10/2022
 */
interface GamesApi {

    @GET("stats/scoreboardv3?LeagueID=00")
    suspend fun getScoreboard(@Query("GameDate") dayDate: String): ScoreboardResponseDto
}