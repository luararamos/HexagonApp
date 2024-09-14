package com.luaramartins.hexagonapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.luaramartins.hexagonapp.presentation.screens.HomeScreen
import com.luaramartins.hexagonapp.presentation.screens.InactiveScreen
import com.luaramartins.hexagonapp.presentation.screens.InfoScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ItemsMenu.Screen1.ruta,
    ) {
        composable(ItemsMenu.Screen1.ruta){
            HomeScreen()
        }
        composable(ItemsMenu.Screen2.ruta){
            InactiveScreen()
        }
        composable(ItemsMenu.Screen3.ruta){
            InfoScreen()
        }
    }
}