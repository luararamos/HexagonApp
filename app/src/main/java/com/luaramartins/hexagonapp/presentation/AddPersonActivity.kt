package com.luaramartins.hexagonapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.luaramartins.hexagonapp.presentation.screens.addPerson.AddPersonFormScreen

class AddPersonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddPersonFormScreen()

            val personId = intent.getIntExtra("PERSON_ID", -1)
            if (personId != -1) {
                AddPersonFormScreen(personId)
            }
        }


    }
}