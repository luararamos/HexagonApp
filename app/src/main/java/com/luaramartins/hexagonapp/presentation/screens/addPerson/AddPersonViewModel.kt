package com.luaramartins.hexagonapp.presentation.screens.addPerson

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.common.CpfFormatter
import com.luaramartins.hexagonapp.common.DateFormatter
import com.luaramartins.hexagonapp.common.ValidationPerson
import com.luaramartins.hexagonapp.data.local.Person
import com.luaramartins.hexagonapp.data.local.saveImageToInternalStorage
import com.luaramartins.hexagonapp.domain.PersonRepository
import kotlinx.coroutines.launch

class AddPersonViewModel(
    private val applicationContext: Context,
    private val personRepository: PersonRepository
) : ViewModel() {

    val name = MutableLiveData<TextFieldValue>(TextFieldValue(""))
    val nameValid = MutableLiveData<Boolean>(true)
    val nameErrorMessage = MutableLiveData<String>("")

    val date = MutableLiveData<TextFieldValue>(TextFieldValue(""))
    val dateValid = MutableLiveData<Boolean>(true)
    val dateErrorMessage = MutableLiveData<String>("")

    val cpf = MutableLiveData<TextFieldValue>(TextFieldValue(""))
    val cpfValid = MutableLiveData<Boolean>(true)
    val cpfErrorMessage = MutableLiveData<String>("")

    val city = MutableLiveData<TextFieldValue>(TextFieldValue(""))
    val cityValid = MutableLiveData<Boolean>(true)
    val cityErrorMessage = MutableLiveData<String>("")

    private val _photoUri = mutableStateOf<Uri?>(null)
    val photoUri: State<Uri?> = _photoUri



    fun insertPerson() {
        personRepository.insertPerson(
            name = name.value?.text ?: "",
            dateOfBirth = date.value?.text ?: "",
            cpf = cpf.value?.text ?: "",
            city = city.value?.text ?: "",
            photoPath = photoUri.value ?: null,
            active = true
        )

    }

    fun setPhotoUri(uri: Uri?) {
        _photoUri.value = uri
    }

    fun loadPersonData(personId: Int) {
        viewModelScope.launch {
            personRepository.getPersonById(personId).collect { person ->
                name.value = TextFieldValue(person.name)
                date.value = TextFieldValue(person.dateOfBirth)
                cpf.value = TextFieldValue(person.cpf)
                city.value = TextFieldValue(person.city)
                _photoUri.value = person.photoPath?.let { Uri.parse(it) }
            }
        }
    }

    fun updatePerson(personId: Int) {
        viewModelScope.launch {
            val photo = saveImageToInternalStorage(applicationContext, photoUri.value ?: null) ?: ""
            personRepository.updatePerson(
                Person(
                    id = personId,
                    name = name.value?.text ?: "",
                    dateOfBirth = date.value?.text ?: "",
                    cpf = cpf.value?.text ?: "",
                    city = city.value?.text ?: "",
                    photoPath = photo ?: "",
                    active = true

                )

            )
        }
    }

    fun onNameChanged(name: TextFieldValue) {
        this.name.value = name
        nameValid.value = ValidationPerson.isValidName(name.text)
        nameErrorMessage.value =
            if (nameValid.value == true) "" else applicationContext.getString(R.string.name_error)
    }

    fun onDataChanged(date: TextFieldValue) {
        val (formattedDate, newCursorPosition) = DateFormatter.formatDate(
            date.text,
            date.selection.start
        )
        this.date.value = TextFieldValue(formattedDate, TextRange(newCursorPosition))
        dateValid.value = ValidationPerson.isValidDate(formattedDate)
        dateErrorMessage.value =
            if (dateValid.value == true) "" else applicationContext.getString(R.string.date_error)
    }

    fun onCpfChanged(cpf: TextFieldValue) {
        val (formattedCpf, newCursorPosition) = CpfFormatter.formatCpf(
            cpf.text,
            cpf.selection.start
        )
        this.cpf.value = TextFieldValue(formattedCpf, TextRange(newCursorPosition))
        cpfValid.value = ValidationPerson.isValidCpf(formattedCpf)
        cpfErrorMessage.value =
            if (cpfValid.value == true) "" else applicationContext.getString(R.string.cpf_error)
    }

    fun onCityChanged(city: TextFieldValue) {
        this.city.value = city
        cityValid.value = ValidationPerson.isValidCity(city.text)
        cityErrorMessage.value =
            if (cityValid.value == true) "" else applicationContext.getString(R.string.city_error)
    }

}
