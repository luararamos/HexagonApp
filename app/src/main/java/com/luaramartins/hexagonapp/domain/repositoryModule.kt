package com.luaramartins.hexagonapp.domain

import com.luaramartins.hexagonapp.data.local.PersonRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<PersonRepository> { PersonRepositoryImpl(androidContext(),get()) }
}