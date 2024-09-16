package com.luaramartins.hexagonapp.presentation.screens.inactive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luaramartins.hexagonapp.data.local.Person
import com.luaramartins.hexagonapp.domain.PersonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InactiveViewModel (
    private val personRepository: PersonRepository
) : ViewModel() {


    private val _persons = MutableStateFlow<List<Person>>(emptyList())
    val persons: StateFlow<List<Person>> = _persons

    init {
        viewModelScope.launch {
            personRepository.getAllInactivePerson().collect { personList ->
                _persons.value = personList
            }
        }
    }


}