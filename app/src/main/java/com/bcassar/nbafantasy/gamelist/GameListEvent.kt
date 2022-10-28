package com.bcassar.nbafantasy.gamelist

import com.bcassar.domain.model.Game

/**
 * Created by bcassar on 27/10/2022
 */
sealed class GameListEvent {

    object GameListFetching : GameListEvent()

    data class GameListFetchingFailed(val throwable: Throwable) : GameListEvent()

    data class GameListFetched(val games: List<Game>) : GameListEvent()

}