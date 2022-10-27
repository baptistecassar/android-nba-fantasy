package com.bcassar.nbafantasy

import android.app.Application
import com.bcassar.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by bcassar on 27/10/2022
 */
class NbaFantasyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(listOf(dataModule))
            androidContext(this@NbaFantasyApp)
        }
    }

}