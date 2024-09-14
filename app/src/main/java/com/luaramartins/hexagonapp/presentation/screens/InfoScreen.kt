package com.luaramartins.hexagonapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun InfoScreen() {
    Column {
        Text(text = "Informações Aplicativo",
            style = MaterialTheme.typography.h1)
    }
}