package com.bcassar.domain.model

/**
 * Created by bcassar on 27/10/2022
 */
data class Team(
    val teamID: Long,
    val teamName: String,
    val teamCity: String,
    val teamTricode: String,
    val teamSlug: String,
    val wins: Long,
    val losses: Long,
)
