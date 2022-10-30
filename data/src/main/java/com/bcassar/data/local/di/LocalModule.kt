package com.bcassar.data.local.di

import androidx.room.Room
import com.bcassar.data.local.NbaFantasyDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by bcassar on 27/10/2022
 */

val localDataModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            NbaFantasyDatabase::class.java,
            "NbaFantasyDatabase.db"
        ).build()
    }

    single {
        get<NbaFantasyDatabase>().gamesDao()
    }

    single {
        get<NbaFantasyDatabase>().teamsDao()
    }

    single {
        get<NbaFantasyDatabase>().playersGameStatsDao()
    }

}