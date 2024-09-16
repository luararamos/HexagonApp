package com.luaramartins.hexagonapp

import android.app.Application
import com.luaramartins.hexagonapp.data.local.databaseModule
import com.luaramartins.hexagonapp.domain.repositoryModule
import com.luaramartins.hexagonapp.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class HexagonApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@HexagonApp)
            modules(listOf(viewModelModule, repositoryModule, databaseModule))
        }
    }
}