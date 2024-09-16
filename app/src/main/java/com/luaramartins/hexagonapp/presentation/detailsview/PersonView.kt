package com.luaramartins.hexagonapp.presentation.detailsview

import androidx.compose.ui.graphics.painter.Painter

data class PersonView (
    val name: String,
    val dateOfBirth: String,
    val cpf: String,
    val city: String,
    val photo: Painter,
    val active: Boolean
)