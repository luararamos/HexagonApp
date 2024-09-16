package com.luaramartins.hexagonapp.domain

import com.luaramartins.hexagonapp.data.local.PersonDao
import com.luaramartins.hexagonapp.data.local.PersonRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PersonRepository> { PersonRepositoryImpl(get()) }
}