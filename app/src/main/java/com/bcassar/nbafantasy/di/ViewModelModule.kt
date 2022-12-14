package com.bcassar.nbafantasy.di

import com.bcassar.nbafantasy.gamelist.GameListViewModel
import com.bcassar.nbafantasy.playerstatslist.PlayerGameStatsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by bcassar on 27/10/2022
 */

val viewModelsModule = module {
    viewModel { parameters -> GameListViewModel(dayDate = parameters.get(), get()) }
    viewModel { parameters -> PlayerGameStatsListViewModel(dayDate = parameters.get(), get()) }
}