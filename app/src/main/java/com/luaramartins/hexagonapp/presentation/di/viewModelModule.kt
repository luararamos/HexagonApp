package com.luaramartins.hexagonapp.presentation.di

import com.luaramartins.hexagonapp.presentation.screens.addPerson.AddPersonViewModel
import com.luaramartins.hexagonapp.presentation.screens.home.HomeViewModel
import com.luaramartins.hexagonapp.presentation.screens.inactive.InactiveViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AddPersonViewModel(androidContext(), get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { InactiveViewModel(get()) }
}