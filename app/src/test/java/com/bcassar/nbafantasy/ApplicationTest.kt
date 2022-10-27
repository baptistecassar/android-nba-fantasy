package com.bcassar.nbafantasy

import com.bcassar.data.di.dataModule
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

/**
 * Created by bcassar on 27/10/2022
 */
class ApplicationTest : KoinTest {

    @Test
    fun verifyKoinApp() {
        koinApplication {
            modules(dataModule)
            checkModules()
        }
    }

}