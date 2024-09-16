package com.luaramartins.hexagonapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.presentation.components.SimpleToolbar
import com.luaramartins.hexagonapp.ui.theme.MEDIUM_PADDING
import com.luaramartins.hexagonapp.ui.theme.SMALL_PADDING

@Composable
fun InfoScreen() {
    Column(Modifier.fillMaxSize()) {
        SimpleToolbar(title = stringResource(id = R.string.information))
        Image(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = SMALL_PADDING, horizontal = MEDIUM_PADDING)
            .align(Alignment.CenterHorizontally), painter = painterResource(id = R.drawable.img_info_app_person), contentDescription = "image_info")
        Text(modifier = Modifier.padding(vertical = SMALL_PADDING, horizontal = MEDIUM_PADDING), text = stringResource(id = R.string.app_info_description))

    }
}