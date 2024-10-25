package com.example.menudeaplicaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import com.example.menudeaplicaciones.navigation.NavManager
import com.example.menudeaplicaciones.ui.theme.MenuDeAplicacionesTheme
//hola

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavManager()
        }
    }
}