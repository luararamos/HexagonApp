package com.luaramartins.hexagonapp.domain

import com.luaramartins.hexagonapp.data.local.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    fun insertPerson(person: Person)

    fun getAllActivePerson(): Flow<List<Person>>

    fun getAllInactivePerson(): Flow<List<Person>>

}