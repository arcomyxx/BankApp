package com.example.bankapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MenuNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MenuScreen.MyAccounts.route,
    ) {
        composable(route = MenuScreen.MyAccounts.route) {
            MyAccountsNavigation(navController = rememberNavController())
        }
        composable(route = MenuScreen.Simulation.route) {
        }
        composable(route = MenuScreen.YouToPlay.route) {
        }
    }
}

sealed class MenuScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {
    object MyAccounts : MenuScreen(
        route = "my_accounts",
        title = "Mes Comptes",
        icon = Icons.Default.Star,
    )

    object Simulation : MenuScreen(
        route = "simulation",
        title = "Simulation",
        icon = Icons.Default.Star,
    )

    object YouToPlay : MenuScreen(
        route = "you_to_play",
        title = "à vous de jouer",
        icon = Icons.Default.Star,
    )
}