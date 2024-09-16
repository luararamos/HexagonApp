package com.luaramartins.hexagonapp.presentation.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import coil.compose.rememberImagePainter

@Composable
fun DisplayImage(imageUri: Uri?) {
    imageUri?.let {
        Image(painter = rememberImagePainter(it), contentDescription = "Imagem selecionada")
    }
}