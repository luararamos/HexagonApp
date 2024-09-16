package com.luaramartins.hexagonapp.presentation.screens.inactive

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
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
        "",
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