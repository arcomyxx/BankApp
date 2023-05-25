package com.example.bankapp.presentation.views.home

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bankapp.presentation.navigation.MenuScreen

@Composable
fun BottomMenu(
    navController: NavHostController,
) {
    val menu = listOf(MenuScreen.MyAccounts, MenuScreen.Simulation, MenuScreen.YouToPlay)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    val menuDestination = menu.any { it.route == currentRoute?.route }
    if (menuDestination) {
        NavigationBar{
            menu.forEach { menuItem ->
                NavigationBarItem(
                    selected = currentRoute?.route == menuItem.route,
                    label = { Text(text = menuItem.title) },
                    icon = { Icon(imageVector = menuItem.icon, contentDescription = "Menu item icon") },
                    onClick = {
                        if (currentRoute?.route != menuItem.route) {
                            navController.navigate(menuItem.route)
                        }
                    }
                )
            }
        }
    }
}