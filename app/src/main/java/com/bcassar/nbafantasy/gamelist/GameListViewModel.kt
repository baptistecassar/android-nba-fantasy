package com.bcassar.nbafantasy.gamelist

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
class GameListViewModel constructor(
    private val dayDate: String,
    private val gameRepository: GameRepository,
) : ViewModel() {

    private val _gameListEvent =
        MutableLiveData<Event<GameListEvent>>(Event(GameListEvent.GameListFetching))
    val gameListEvent: LiveData<Event<GameListEvent>> = _gameListEvent

    init {
        fetchGameList()
    }

    fun fetchGameList() = CoroutineScope(Dispatchers.IO).launch {
        _gameListEvent.postValue(Event(GameListEvent.GameListFetching))
        try {
            val games = gameRepository.fetchGames(dayDate)
            _gameListEvent.postValue(Event(GameListEvent.GameListFetched(games)))
        } catch (e: Exception) {
            _gameListEvent.postValue(Event(GameListEvent.GameListFetchingFailed(e)))
        }
    }

}