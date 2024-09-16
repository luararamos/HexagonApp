package com.luaramartins.hexagonapp.domain

import android.net.Uri
import com.luaramartins.hexagonapp.data.local.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    fun insertPerson(
        name : String,
        dateOfBirth : String,
        cpf : String,
        city : String,
        photoPath : Uri?,
        active : Boolean
    )

    fun getPersonById(personId: Int): Flow<Person>

    fun updatePerson(person: Person)

    fun getAllActivePerson(): Flow<List<Person>>

    fun getAllInactivePerson(): Flow<List<Person>>

    fun updatePersonStatus(personId: Int, isActive: Boolean)

}