package com.bcassar.nbafantasy.playerstatslist

import com.bcassar.domain.model.PlayerGameStats

/**
 * Created by bcassar on 27/10/2022
 */
sealed class PlayerGameStatsListEvent {

    object PlayerGameStatsListFetching : PlayerGameStatsListEvent()

    data class PlayerGameStatsListFetchingFailed(val throwable: Throwable) :
        PlayerGameStatsListEvent()

    data class PlayerGameStatsListFetched(val playerGameStatsList: List<PlayerGameStats>) :
        PlayerGameStatsListEvent()

}