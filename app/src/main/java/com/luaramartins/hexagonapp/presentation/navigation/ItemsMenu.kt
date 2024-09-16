package com.luaramartins.hexagonapp.presentation.navigation

import com.luaramartins.hexagonapp.R

sealed class ItemsMenu(
    val icon: Int,
    val title: String,
    val ruta: String
){
    object Screen1: ItemsMenu(R.drawable.ic_person_active,"Ativos", "screen1")
    object Screen2: ItemsMenu(R.drawable.ic_person_inactive,"Inativos", "screen2")
    object Screen3: ItemsMenu(R.drawable.ic_info,"Info", "screen3")
}