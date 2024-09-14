package com.luaramartins.hexagonapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Column {
        Text(text = "Inicio",
            style = MaterialTheme.typography.h1)
    }
}