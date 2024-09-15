package com.luaramartins.hexagonapp.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.ui.theme.CORNER_RADIUS_20
import com.luaramartins.hexagonapp.ui.theme.LARGE_PADDING
import com.luaramartins.hexagonapp.ui.theme.MEDIUM_PADDING
import com.luaramartins.hexagonapp.ui.theme.MEDIUM_SPACER
import com.luaramartins.hexagonapp.ui.theme.MIN_SIZE
import com.luaramartins.hexagonapp.ui.theme.SMALL_PADDING
import com.luaramartins.hexagonapp.ui.theme.STROKE_WIDTH_SMALL

@Composable
fun ButtonAction(
    text: String,
    isLoading: Boolean = false,
    arrow: Boolean? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = SMALL_PADDING, horizontal = MEDIUM_PADDING),
        onClick = { if (!isLoading) onClick() },
        contentPadding = PaddingValues(
            vertical = SMALL_PADDING,
            horizontal = LARGE_PADDING
        ),
        enabled = !isLoading,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.colorBackgroundSecond)),
        shape = RoundedCornerShape(CORNER_RADIUS_20),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            if (isLoading) {
                CircularProgressIndicator(
                    color = colorResource(id = R.color.colorTextSecondary),
                    strokeWidth = STROKE_WIDTH_SMALL,
                    modifier = Modifier.size(MIN_SIZE)
                )
                Spacer(Modifier.width(MEDIUM_SPACER))
                Text(
                    text = "Loading...",
                    color = colorResource(id = R.color.colorTextSecondary)
                )
            } else {
                Text(
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    text = text,
                    color = colorResource(id = R.color.colorTextSecondary)
                )
            }

        }
    }
}