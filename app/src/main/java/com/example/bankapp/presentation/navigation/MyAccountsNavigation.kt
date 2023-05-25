package com.example.bankapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bankapp.presentation.views.my_accounts.MyAccountsView
import com.example.bankapp.presentation.views.my_accounts.account_details.AccountDetailsView

const val ID_ARG = "id"

@Composable
fun MyAccountsNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MyAccountsScreen.Root.route,
    ) {
        composable(route = MyAccountsScreen.Root.route) {
            MyAccountsView(navController = navController)
        }

        composable(
            route = "${MyAccountsScreen.Details.route}?$ID_ARG={$ID_ARG}",
            arguments = listOf(
                navArgument(ID_ARG) {
                    type = NavType.StringType
                }
            ),
        ) {
            AccountDetailsView(accountId = it.arguments?.getString(ID_ARG))
        }
    }
}

sealed class MyAccountsScreen(
    val route: String,
) {
    object Root : MyAccountsScreen(
        route = "root",
    )
    object Details : MyAccountsScreen(
        route = "account_details",
    )
}
