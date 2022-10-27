package com.bcassar.sharedtest

import com.bcassar.data.remote.model.ScoreboardResponseDto
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

/**
 * Created by bcassar on 27/10/2022
 */
object Utils {
    const val scoreboardResponseSuccessfulFile = "scoreboard_response_success.json"

    fun getScoreboardResponse(): ScoreboardResponseDto? {
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ScoreboardResponseDto> =
            moshi.adapter(ScoreboardResponseDto::class.java)
        return adapter.fromJson(scoreboardResponse)
    }
}