package com.luaramartins.hexagonapp.common

import com.luaramartins.hexagonapp.data.local.Person
import com.luaramartins.hexagonapp.presentation.detailsview.PersonView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun Person.toPersonView(): PersonView {
    return PersonView(
        name = this.name,
        dateOfBirth = this.dateOfBirth.calculateAge(),
        cpf = this.cpf,
        city = this.city,
        photo = this.photoPath,
        active = this.active
    )
}


fun String.calculateAge(): String {
    val format = "dd/MM/yyyy"
    val sdf = SimpleDateFormat(format, Locale.getDefault())
    val birthDate = sdf.parse(this)
    val currentDate = Calendar.getInstance().time

    birthDate?.let {
        val diffInMillis = currentDate.time - it.time
        val age = (diffInMillis / (1000L * 60 * 60 * 24 * 365)).toInt()
        return age.toString()
    } ?: return ""
}