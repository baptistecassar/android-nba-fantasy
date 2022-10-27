package com.bcassar.data.local.model

import androidx.room.Embedded
import androidx.room.Relation
import com.bcassar.data.local.entity.GameEntity
import com.bcassar.data.local.entity.TeamEntity

/**
 * Created by bcassar on 27/10/2022
 */
data class GameAndTeams(
    @Embedded
    val gameEntity: GameEntity,
    @Relation(
        parentColumn = "awayTeamId",
        entityColumn = "teamId"
    )
    val awayTeam: TeamEntity,
    @Relation(
        parentColumn = "homeTeamId",
        entityColumn = "teamId"
    )
    val homeTeam: TeamEntity,
)
