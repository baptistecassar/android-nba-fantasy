package com.bcassar.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by bcassar on 29/10/2022
 */

@JsonClass(generateAdapter = true)
data class BoxscoreResponseDto(
    @Json(name = "resultSets") val resultSets: List<ResultSetDto>
)

@JsonClass(generateAdapter = true)
data class ResultSetDto(
    @Json(name = "name") val name: String,
    @Json(name = "headers") val headers: List<String>,
    @Json(name = "rowSet") val rowSet: List<List<String>>
)