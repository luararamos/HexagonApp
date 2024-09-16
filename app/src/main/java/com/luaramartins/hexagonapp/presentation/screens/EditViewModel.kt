package com.luaramartins.hexagonapp.presentation.screens

import androidx.lifecycle.ViewModel
import com.luaramartins.hexagonapp.domain.PersonRepository

class EditViewModel(
    private val personRepository: PersonRepository
) : ViewModel() {

    fun enabledPerson(personId: Int){
        personRepository.updatePersonStatus(
            personId = personId, isActive = true
        )
    }
    fun disabledPerson(personId: Int){
        personRepository.updatePersonStatus(
            personId = personId, isActive = false
        )

    }
}