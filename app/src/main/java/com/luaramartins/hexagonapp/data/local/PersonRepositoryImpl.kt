package com.luaramartins.hexagonapp.data.local

import com.luaramartins.hexagonapp.domain.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PersonRepositoryImpl(private val personDao: PersonDao) : PersonRepository {
    override fun insertPerson(person: Person) {
        CoroutineScope(Dispatchers.Main).launch {
            personDao.insertPerson(person)
        }
    }

    override fun getAllActivePerson(): Flow<List<Person>> {
        return personDao.getAllActivePerson()
    }

    override fun getAllInactivePerson(): Flow<List<Person>> {
        return personDao.getAllInactivePerson()
    }

}