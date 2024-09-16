package com.luaramartins.hexagonapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luaramartins.hexagonapp.data.local.Person
import com.luaramartins.hexagonapp.domain.PersonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val personRepository: PersonRepository
) : ViewModel() {


    private val _persons = MutableStateFlow<List<Person>>(emptyList())
    val persons: StateFlow<List<Person>> = _persons

    init {
        viewModelScope.launch {
            personRepository.getAllActivePerson().collect { personList ->
                _persons.value = personList
            }
        }
    }


}