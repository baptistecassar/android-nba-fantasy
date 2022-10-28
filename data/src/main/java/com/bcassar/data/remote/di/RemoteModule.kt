package com.bcassar.data.remote.di

import com.bcassar.data.BuildConfig
import com.bcassar.data.remote.api.GamesApi
import com.bcassar.data.remote.interceptor.NbaStatsInterceptor
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by bcassar on 27/10/2022
 */

val remoteDataModule = module {

    single {
        val builder = OkHttpClient.Builder()
            .addInterceptor(NbaStatsInterceptor())
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(interceptor)
        }
        builder.build()
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