package com.luaramartins.hexagonapp.presentation.screens.addPerson

import android.app.Activity
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.presentation.components.ButtonAction
import com.luaramartins.hexagonapp.presentation.components.CircularImage
import com.luaramartins.hexagonapp.presentation.components.ImagePicker
import com.luaramartins.hexagonapp.presentation.components.TextFieldManager
import com.luaramartins.hexagonapp.ui.theme.BIG_INPUT_HEIGHT
import com.luaramartins.hexagonapp.ui.theme.BIG_INPUT_WIDTH
import com.luaramartins.hexagonapp.ui.theme.CORNER_RADIUS_16
import com.luaramartins.hexagonapp.ui.theme.ELEVATION_16
import com.luaramartins.hexagonapp.ui.theme.MEDIUM_PADDING
import org.koin.androidx.compose.getViewModel

@Composable
fun AddPersonFormScreen(
    idPerson: Int? = null
) {
    val context = LocalContext.current

    val viewModel: AddPersonViewModel = getViewModel()

    val name by viewModel.name.observeAsState(TextFieldValue(""))
    val nameValid by viewModel.nameValid.observeAsState(true)
    val nameErrorMessage by viewModel.nameErrorMessage.observeAsState("")

    val date by viewModel.date.observeAsState(TextFieldValue(""))
    val dateValid by viewModel.dateValid.observeAsState(true)
    val dateErrorMessage by viewModel.dateErrorMessage.observeAsState("")

    val cpf by viewModel.cpf.observeAsState(TextFieldValue(""))
    val cpfValid by viewModel.cpfValid.observeAsState(true)
    val cpfErrorMessage by viewModel.cpfErrorMessage.observeAsState("")

    val city by viewModel.city.observeAsState(TextFieldValue(""))
    val cityValid by viewModel.cityValid.observeAsState(true)
    val cityErrorMessage by viewModel.cityErrorMessage.observeAsState("")

    var imageUri by remember { mutableStateOf<Uri?>(null) }


    LaunchedEffect(idPerson) {
        if (idPerson != null) {
            viewModel.loadPersonData(idPerson)
        }
    }

    LazyColumn {
        item {
            Card(
                modifier = Modifier
                    .padding(horizontal = MEDIUM_PADDING, vertical = MEDIUM_PADDING)
                    .fillMaxWidth()
                    .shadow(
                        elevation = ELEVATION_16,
                        shape = RoundedCornerShape(corner = CornerSize(CORNER_RADIUS_16)),
                        spotColor = Color.Black
                    )
                    .background(
                        color = colorResource(id = R.color.colorWhite),
                        shape = RoundedCornerShape(corner = CornerSize(CORNER_RADIUS_16))
                    ),
                shape = RoundedCornerShape(corner = CornerSize(CORNER_RADIUS_16))
            ) {

                Column(
                    modifier = Modifier
                        .background(
                            colorResource(id = R.color.colorWhite)
                        )
                ) {
                    Spacer(modifier = Modifier.width(32.dp))
                    Text(
                        modifier = Modifier
                            .padding(horizontal = MEDIUM_PADDING),
                        text = stringResource(id = R.string.new_image),
                        color = colorResource(id = R.color.colorPrimary),
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Row {

                        Spacer(modifier = Modifier.width(32.dp))
                        imageUri?.let {
                            CircularImage(image = rememberImagePainter(it), modifier = Modifier)
                        } ?: Text(
                            modifier = Modifier
                                .size(width = BIG_INPUT_WIDTH, height = BIG_INPUT_HEIGHT),
                            text = "Nenhuma imagem selecionada"
                        )
                        Spacer(modifier = Modifier.width(32.dp))

                        ImagePicker(onImageUriSelected = { uri ->
                            imageUri = uri
                            viewModel.setPhotoUri(uri)
                        })
                    }

                }


            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(horizontal = MEDIUM_PADDING, vertical = MEDIUM_PADDING)
                    .fillMaxWidth()
                    .shadow(
                        elevation = ELEVATION_16,
                        shape = RoundedCornerShape(corner = CornerSize(CORNER_RADIUS_16)),
                        spotColor = Color.Black
                    )
                    .background(
                        color = colorResource(id = R.color.colorWhite),
                        shape = RoundedCornerShape(corner = CornerSize(CORNER_RADIUS_16))
                    ),
                shape = RoundedCornerShape(corner = CornerSize(CORNER_RADIUS_16))
            ) {
                Column(
                    modifier = Modifier
                        .background(
                            colorResource(id = R.color.colorWhite)
                        )
                ) {
                    Spacer(modifier = Modifier.width(32.dp))
                    Text(
                        modifier = Modifier
                            .padding(horizontal = MEDIUM_PADDING),
                        text = stringResource(id = R.string.new_person),
                        color = colorResource(id = R.color.colorPrimary),
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.width(32.dp))


                    TextFieldManager(
                        label = stringResource(id = R.string.name),
                        isError = !nameValid,
                        errorMessage = nameErrorMessage,
                        leadingIconId = R.drawable.ic_person,
                        textFieldValue = name,
                        onTextChange = { viewModel.onNameChanged(it) }
                    )

                    TextFieldManager(
                        label = stringResource(id = R.string.date_of_birth),
                        isError = !dateValid,
                        errorMessage = dateErrorMessage,
                        leadingIconId = R.drawable.ic_calendar,
                        textFieldValue = date,
                        onTextChange = { viewModel.onDataChanged(it) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )

                    TextFieldManager(
                        label = stringResource(id = R.string.cpf),
                        isError = !cpfValid,
                        errorMessage = cpfErrorMessage,
                        leadingIconId = R.drawable.ic_cpf,
                        textFieldValue = cpf,
                        onTextChange = { viewModel.onCpfChanged(it) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )

                    TextFieldManager(
                        label = stringResource(id = R.string.city),
                        isError = !cityValid,
                        errorMessage = cityErrorMessage,
                        leadingIconId = R.drawable.ic_city,
                        textFieldValue = city,
                        onTextChange = { viewModel.onCityChanged(it) }
                    )

                    ButtonAction(
                        text = stringResource(
                            id = if (idPerson != null) R.string.edit  else R.string.save
                        )) {

                        if (idPerson != null) {
                            viewModel.updatePerson(idPerson)
                        } else {
                            viewModel.insertPerson()
                        }
                        (context as? Activity)?.finish()
                    }


                }
            }
        }
    }


}
