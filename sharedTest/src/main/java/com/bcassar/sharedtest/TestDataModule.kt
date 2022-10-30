package com.bcassar.sharedtest

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.bcassar.data.local.NbaFantasyDatabase
import com.bcassar.data.remote.api.GamesApi
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by bcassar on 26/10/2022
 */

val testRemoteDataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(MockInterceptor())
            .build()
    }

    single {
        Moshi.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://stats.nba.com/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(GamesApi::class.java)
    }

}

val testLocalDataModule = module {

    single {
        Room.databaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NbaFantasyDatabase::class.java,
            "NbaFantasyDatabase.db"
        ).allowMainThreadQueries().build()
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
