package com.example.menudeaplicaciones.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dogyears.DogAgeCalculatorScreen
import com.example.examendescuento.DiscountsScreen
import com.example.loto.LoteriaScreen
import com.example.menudeaplicaciones.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable("DogYears") {
            DogAgeCalculatorScreen(navController)
        }
        composable("Discounts") {
            DiscountsScreen(navController)
        }
        composable("Loteria") {
            LoteriaScreen(navController)
        }
    }
}
