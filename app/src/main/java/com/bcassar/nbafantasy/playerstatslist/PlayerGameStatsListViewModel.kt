package com.bcassar.nbafantasy.playerstatslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bcassar.domain.repository.GameRepository
import com.bcassar.nbafantasy.utils.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by bcassar on 27/10/2022
 */
class PlayerGameStatsListViewModel constructor(
    private val dayDate: String,
    private val gameRepository: GameRepository,
) : ViewModel() {

    private val _playerGameStatsListEvent =
        MutableLiveData<Event<PlayerGameStatsListEvent>>(Event(PlayerGameStatsListEvent.PlayerGameStatsListFetching))
    val playerGameStatsListEvent: LiveData<Event<PlayerGameStatsListEvent>> =
        _playerGameStatsListEvent

    fun fetchPlayerGameStatsList() = CoroutineScope(Dispatchers.IO).launch {
        _playerGameStatsListEvent.postValue(Event(PlayerGameStatsListEvent.PlayerGameStatsListFetching))
        try {
            val playerGameStatsList = gameRepository.fetchPlayersGameStats(dayDate)
            _playerGameStatsListEvent.postValue(
                Event(PlayerGameStatsListEvent.PlayerGameStatsListFetched(playerGameStatsList))
            )
        } catch (e: Exception) {
            _playerGameStatsListEvent.postValue(
                Event(PlayerGameStatsListEvent.PlayerGameStatsListFetchingFailed(e))
            )
        }
    }

}