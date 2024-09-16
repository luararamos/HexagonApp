package com.luaramartins.hexagonapp.data.local

import android.content.Context
import android.net.Uri
import com.luaramartins.hexagonapp.domain.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PersonRepositoryImpl(val context: Context,private val personDao: PersonDao) : PersonRepository {
    override fun insertPerson(
        name: String,
        dateOfBirth: String,
        cpf: String,
        city: String,
        photoPath: Uri?,
        active: Boolean
    ) {

        CoroutineScope(Dispatchers.Main).launch {
            val photo =saveImageToInternalStorage(context, photoPath) ?: ""
            personDao.insertPerson(Person(
                name = name,
                dateOfBirth = dateOfBirth,
                cpf = cpf,
                city = city,
                photoPath = photo,
                active = active
            ))
        }
    }

    override fun getAllActivePerson(): Flow<List<Person>> {
        return personDao.getAllActivePerson()
    }

    override fun getAllInactivePerson(): Flow<List<Person>> {
        return personDao.getAllInactivePerson()
    }

    override fun updatePersonStatus(personId: Int, isActive: Boolean) {
        CoroutineScope(Dispatchers.Main).launch {
            personDao.updatePersonActiveStatus(personId, isActive)
        }
    }

}