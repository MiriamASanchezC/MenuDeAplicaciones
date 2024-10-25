package com.example.loto

import android.os.Bundle

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.loto.viewModels.LoteriaViewModel
import com.example.loto.views.Loteriaview
import com.example.loto.ui.theme.LotoTheme
import com.example.menudeaplicaciones.components.MainIconButton
import com.example.menudeaplicaciones.components.TitleBar
val LightBlue = Color(0xFF8FC8F0)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoteriaScreen(navController: NavController) {
    val viewModel: LoteriaViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Lotería") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = LightBlue
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) { paddingValues ->
        LoteriaContent(viewModel, paddingValues)
    }
}


@Composable
fun LoteriaContent(viewModel: LoteriaViewModel, paddingValues: PaddingValues) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Loteriaview(viewModels = viewModel)
    }
}