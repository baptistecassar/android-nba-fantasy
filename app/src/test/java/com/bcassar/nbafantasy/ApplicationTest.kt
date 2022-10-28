package com.bcassar.nbafantasy

import androidx.test.core.app.ApplicationProvider
import com.bcassar.data.local.di.localDataModule
import com.bcassar.data.remote.di.remoteDataModule
import com.bcassar.domain.di.domainModule
import com.bcassar.nbafantasy.di.viewModelsModule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.robolectric.RobolectricTestRunner

/**
 * Created by bcassar on 27/10/2022
 */
@RunWith(RobolectricTestRunner::class)
class ApplicationTest : KoinTest {

    @Test
    fun verifyKoinApp() {
        koinApplication {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(remoteDataModule, localDataModule, domainModule, viewModelsModule)
            checkModules()
        }
    }

}