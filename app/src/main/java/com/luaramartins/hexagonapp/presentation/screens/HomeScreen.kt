package com.luaramartins.hexagonapp.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.presentation.components.CardPerson
import com.luaramartins.hexagonapp.presentation.components.SimpleToolbar
import com.luaramartins.hexagonapp.presentation.detailsview.PersonView

@Composable
fun HomeScreen() {

    val mockPersonView = PersonView(
        name = "Lise",
        dateOfBirth = "27",
        cpf="44579251873",
        city="São Paulo",
        photo = painterResource(id = R.drawable.img_info_app_person),
        active = true
    )
    val mockList = listOf<PersonView>(mockPersonView, mockPersonView, mockPersonView)

    LazyColumn {
        item {
            SimpleToolbar(title = stringResource(id = R.string.person_active))
        }

        items(mockList) { person ->
            CardPerson(person = person)

        }
    }

}