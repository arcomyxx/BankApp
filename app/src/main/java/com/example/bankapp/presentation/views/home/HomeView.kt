package com.example.bankapp.presentation.views.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.bankapp.presentation.navigation.MenuNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    navController: NavHostController,
) {
    Scaffold(
        bottomBar = { BottomMenu(navController) },
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding),
        ) {
            MenuNavigation(navController = navController)
        }
    }
}