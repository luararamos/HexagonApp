package com.luaramartins.hexagonapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "date_of_birth") val dateOfBirth: String = "",
    @ColumnInfo(name = "cpf") val cpf: String = "",
    @ColumnInfo(name = "city") val city: String = "",
    @ColumnInfo(name = "photo_path") val photoPath: String = "",
    @ColumnInfo(name = "active") val active: Boolean = true
)