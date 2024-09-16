package com.luaramartins.hexagonapp.presentation.detailsview


data class PersonView (
    val id: Int,
    val name: String,
    val dateOfBirth: String,
    val cpf: String,
    val city: String,
    val photo: String,
    val active: Boolean
)