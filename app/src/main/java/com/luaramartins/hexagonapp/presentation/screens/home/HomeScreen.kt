package com.luaramartins.hexagonapp.presentation.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
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
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {

    val viewModel: HomeViewModel = getViewModel()

    val listPerson by viewModel.persons.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.persons
    }

    LazyColumn {
        item {
            SimpleToolbar(title = stringResource(id = R.string.person_active))
        }

        items(listPerson) { person ->

            CardPerson(person = person.toPersonView())

        }
    }

}