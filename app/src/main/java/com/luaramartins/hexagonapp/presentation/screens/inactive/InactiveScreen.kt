package com.luaramartins.hexagonapp.presentation.screens.inactive

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.common.toPersonView
import com.luaramartins.hexagonapp.presentation.components.CardPerson
import com.luaramartins.hexagonapp.presentation.components.SimpleToolbar
import com.luaramartins.hexagonapp.presentation.detailsview.PersonView
import com.luaramartins.hexagonapp.presentation.screens.home.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun InactiveScreen() {

    val viewModel: InactiveViewModel = getViewModel()
    val listPerson by viewModel.persons.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.persons
    }

    LazyColumn {
        item {
            SimpleToolbar(title = stringResource(id = R.string.person_inactive))
        }

        items(listPerson) { person ->
            CardPerson(person = person.toPersonView())

        }
    }

}