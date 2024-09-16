package com.luaramartins.hexagonapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)

    @Update
    suspend fun updatePerson(person: Person)

    @Query("SELECT * FROM Person WHERE active = 1")
    fun getAllActivePerson(): Flow<List<Person>>

    @Query("SELECT * FROM Person WHERE active = 1")
    fun getAllInactivePerson(): Flow<List<Person>>
}