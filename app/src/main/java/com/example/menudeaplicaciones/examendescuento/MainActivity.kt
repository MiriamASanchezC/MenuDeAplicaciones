package com.example.examendescuento

import android.os.Bundle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.examendescuento.ui.theme.ExamenDescuentoTheme
import com.example.menudeaplicaciones.components.MainIconButton

val LightPink = Color(0xFFFFC0CB)
val LightPurple = Color(0xFFC58FF0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscountsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calculadora De Descuentos", color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = LightPurple
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()  // Navegación hacia atrás
                    }
                }
            )
        }
    ) { paddingValues ->
        // Llamamos a PosicionPantalla sin pasar navController
        PosicionPantalla(paddingValues)
    }
}

@Composable
private fun PosicionPantalla(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var resultadoDescuento by remember { mutableStateOf("") }
        var resultadoTotal by remember { mutableStateOf("") }

        Text(
            text = "Calculadora Descuento",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )

        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") }
        )

        OutlinedTextField(
            value = descuento,
            onValueChange = { descuento = it },
            label = { Text("%Descuento") }
        )

        ElevatedButton(
            onClick = {
                val precioDouble = precio.toDoubleOrNull() ?: 0.0
                val descuentoInt = descuento.toIntOrNull() ?: 0
                val res = (precioDouble * descuentoInt) / 100
                resultadoDescuento = res.toString()
                val res2 = precioDouble - res
                resultadoTotal = res2.toString()
            },
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = LightPink,
                contentColor = Color.Black
            )
        ) {
            Text("Calcular")
        }

        ElevatedButton(onClick = {
            resultadoDescuento = ""
            precio = ""
            descuento = ""
            resultadoTotal = ""
        }, colors = ButtonDefaults.elevatedButtonColors(
            containerColor = LightPink,
            contentColor = Color.Black
        )) {
            Text(text = "Borrar")
        }

        OutlinedTextField(
            value = resultadoDescuento,
            readOnly = true,
            onValueChange = {},
            label = { Text("Descuento") }
        )
        OutlinedTextField(
            value = resultadoTotal,
            readOnly = true,
            onValueChange = {},
            label = { Text("Total") }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExamenDescuentoTheme {

         DiscountsScreen(navController = rememberNavController()) // Necesitarías importar el NavController.
        //Text("Vista previa de la calculadora") // Placeholder para la vista previa.
    }
}
