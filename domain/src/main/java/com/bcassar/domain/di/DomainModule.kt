package com.bcassar.domain.di

import com.bcassar.domain.repository.GameRepository
import com.bcassar.domain.repository.GameRepositoryImpl
import org.koin.dsl.module

/**
 * Created by bcassar on 27/10/2022
 */

val domainModule = module {

    single<GameRepository> {
        GameRepositoryImpl(get(), get(), get())
    }

}