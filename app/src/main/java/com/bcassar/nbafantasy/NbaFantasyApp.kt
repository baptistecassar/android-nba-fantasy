package com.bcassar.nbafantasy

import android.app.Application
import com.bcassar.data.local.di.localDataModule
import com.bcassar.data.remote.di.remoteDataModule
import com.bcassar.domain.di.domainModule
import com.bcassar.nbafantasy.di.viewModelsModule
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
            androidContext(this@NbaFantasyApp)
            modules(listOf(remoteDataModule, localDataModule, domainModule, viewModelsModule))
        }
    }

}