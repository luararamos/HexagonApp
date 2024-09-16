package com.luaramartins.hexagonapp.presentation.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.ui.theme.FONT_24
import com.luaramartins.hexagonapp.ui.theme.SMALL_PADDING

@Composable
fun SimpleToolbar(title: String) {
    val context = LocalContext.current

    Row(
        modifier = Modifier.padding(SMALL_PADDING),
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            text = title,
            fontSize = FONT_24,
            color = colorResource(id = R.color.colorTextSecondary)
        )
    }

}