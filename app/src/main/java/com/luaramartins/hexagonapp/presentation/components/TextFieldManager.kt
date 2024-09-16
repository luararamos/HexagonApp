package com.luaramartins.hexagonapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.ui.theme.FONT_16
import com.luaramartins.hexagonapp.ui.theme.MEDIUM_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldManager(
    label: String,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    errorMessage: String = stringResource(id = R.string.generic_error),
    leadingIconId: Int? = null,
    trailingIconId: Int? = null,
    textFieldValue: TextFieldValue,
    onTextChange: (TextFieldValue) -> Unit,
) {
    var textState by remember { mutableStateOf(textFieldValue) }
    val errorText = if (isError) errorMessage else ""
    val leadingIcon: Painter? = leadingIconId?.let { painterResource(id = it) }
    val trailingIcon: Painter? = trailingIconId?.let { painterResource(id = it) }

    LaunchedEffect(textFieldValue) {
        textState = textFieldValue
    }
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MEDIUM_PADDING)
                .background(colorResource(id = R.color.colorWhite)),
            text = label,
            color = colorResource(id = R.color.colorPrimary),
            style = TextStyle(
                fontSize = FONT_16
            ),
        )
        OutlinedTextField(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(horizontal = MEDIUM_PADDING),
            value = textState,
            onValueChange = { newText ->
                textState = newText
                onTextChange(newText)
            },
            isError = isError,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(onDone = { }),
            supportingText = {
                if (isError) {
                    Text(text = errorText, color = colorResource(id = R.color.colorError))
                }
            },
            leadingIcon = {
                if (leadingIcon != null) Icon(painter = leadingIcon, contentDescription = null)
            },
            trailingIcon = {
                if (trailingIcon != null) Icon(painter = trailingIcon, contentDescription = null)
            },
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                focusedBorderColor = colorResource(id = R.color.colorPrimary)
            )
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldManager(
    label: String,
    isError: Boolean,
    onTextChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {

    val textState = remember { mutableStateOf("") }
    val errorText = if (isError) "Erro! Verifique a entrada." else ""

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MEDIUM_PADDING)
                .background(colorResource(id = R.color.colorWhite)),
            text = label,
            color = colorResource(id = R.color.colorPrimary),
            style = TextStyle(
                fontSize = FONT_16
            ),
        )
        OutlinedTextField(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(horizontal = MEDIUM_PADDING),
            onValueChange = { newText ->
                textState.value = newText
                onTextChange(newText)

            },
            value = textState.value,
            isError = isError,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(onDone = { }),
            supportingText = {
                Text(text = errorText)
            },
            maxLines = 1,
            colors = TextFieldDefaults
                .outlinedTextFieldColors(
                    containerColor = Color.White,
                    focusedBorderColor = colorResource(id = R.color.colorPrimary)
                )
        )
    }
}