package com.bcassar.data

import com.bcassar.data.remote.api.GamesApi
import com.bcassar.data.utils.MockInterceptor
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by bcassar on 26/10/2022
 */

val testDataModule = module {

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
