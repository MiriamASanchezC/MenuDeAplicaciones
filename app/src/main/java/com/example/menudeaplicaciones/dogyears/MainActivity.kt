package com.example.dogyears

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dogyears.ui.theme.DogYearsTheme
import com.example.menudeaplicaciones.R
import com.example.menudeaplicaciones.components.MainIconButton

val LightPink = Color(0xFFFFC0CB)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogAgeCalculatorScreen(navController: NavController?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calculadora de Edad de Perro", color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = LightPink
                ),
                navigationIcon = {
                    if (navController != null) {
                        MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                            navController.popBackStack()
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        PosicionPantalla(paddingValues = paddingValues)
    }
}

@Composable
private fun PosicionPantalla(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var edad by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("") }

        val imagen: Painter = painterResource(id = R.drawable.perrito)

        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center
        )

        Text(
            text = "Mis Años Perrunos",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )

        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Mi edad humana") }
        )

        ElevatedButton(
            onClick = {
                val edadInt = edad.toIntOrNull() ?: 0
                resultado = (edadInt * 7).toString()
            },
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = LightPink,
                contentColor = Color.Black
            )
        ) {
            Text("Calcular")
        }

        OutlinedTextField(
            value = resultado,
            readOnly = true,
            onValueChange = {},
            label = { Text("Edad Perruna") }
        )

        ElevatedButton(
            onClick = {
                resultado = ""
                edad = ""
            },
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = LightPink,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Borrar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DogYearsTheme {
        DogAgeCalculatorScreen(navController = null)
    }
}
