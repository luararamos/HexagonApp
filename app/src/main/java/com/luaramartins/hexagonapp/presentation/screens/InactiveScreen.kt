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
fun InactiveScreen() {
    val mockPersonView = PersonView(
        "Lise",
        "27",
        "44579251873",
        "São Paulo",
        painterResource(id = R.drawable.ic_person_active),
        active = false
    )
    val mockList = listOf<PersonView>(mockPersonView, mockPersonView, mockPersonView)

    LazyColumn {
        item {
            SimpleToolbar(title = stringResource(id = R.string.person_inactive))
        }

        items(mockList) { person ->
            CardPerson(person = person)

        }
    }

}