package com.luaramartins.hexagonapp.data.local

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "hexagon.db"
        ).build()
    }

    single { get<AppDatabase>().personDao() }
}