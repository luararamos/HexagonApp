package com.luaramartins.hexagonapp.presentation.screens.addPerson

import android.content.Context
import android.view.textclassifier.TextSelection
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luaramartins.hexagonapp.R
import com.luaramartins.hexagonapp.common.CpfFormatter
import com.luaramartins.hexagonapp.common.DateFormatter
import com.luaramartins.hexagonapp.common.ValidationPerson

class AddPersonViewModel(
    private val applicationContext: Context,
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

    private var _state = mutableStateOf("")
    val state: State<String> = _state

    private var _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private var _errorMessage = mutableStateOf("")
    val errorMessage: State<String> = _errorMessage

    fun onNameChanged(name: TextFieldValue) {
        this.name.value = name
        nameValid.value = ValidationPerson.isValidName(name.text)
        nameErrorMessage.value =
            if (nameValid.value == true) "" else applicationContext.getString(R.string.name_error)
    }

    fun onDataChanged(date: TextFieldValue) {
        val (formattedDate, newCursorPosition) = DateFormatter.formatDate(date.text, date.selection.start)
        this.date.value = TextFieldValue(formattedDate, TextRange(newCursorPosition))
        dateValid.value = ValidationPerson.isValidDate(formattedDate)
        dateErrorMessage.value =
            if (dateValid.value == true) "" else applicationContext.getString(R.string.date_error)
    }

    fun onCpfChanged(cpf: TextFieldValue) {
        val (formattedCpf, newCursorPosition) = CpfFormatter.formatCpf(cpf.text, cpf.selection.start)
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
