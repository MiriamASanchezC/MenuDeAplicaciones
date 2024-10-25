package com.example.menudeaplicaciones.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.menudeaplicaciones.components.*

val LightPink = Color(0xFFFFC0CB)
val LightBlue = Color(0xFF8FC8F0)
val LightPurple = Color(0xFFC58FF0)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Libreria") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = LightPink
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Menu")
        Space()

        MainButton(name = "Años Perrunos", backColor = LightPink, color = Color.White) {
            navController.navigate("DogYears")
        }
        MainButton(name = "Descuentos", backColor = LightPurple, color = Color.White) {
            navController.navigate("Discounts")
        }
        MainButton(name = "Loteria", backColor = LightBlue, color = Color.White) {
            navController.navigate("Loteria")
        }
    }
}
