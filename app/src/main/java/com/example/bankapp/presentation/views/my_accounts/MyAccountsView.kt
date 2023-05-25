package com.example.bankapp.presentation.views.my_accounts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bankapp.R
import com.example.bankapp.presentation.view_models.MyAccountsViewModel
import com.example.bankapp.presentation.views.common.ErrorView
import com.example.bankapp.presentation.views.my_accounts.banks.BanksView

@Composable
fun MyAccountsView(
    navController: NavHostController,
    viewModel: MyAccountsViewModel = MyAccountsViewModel(),
) {
    val state = viewModel.state.value

    if (state.error == null) {
        Column {
            Text(
                text = stringResource(id = R.string.my_accounts),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(20.dp),
            )

            if (state.CABanks.isNotEmpty()) {
                BanksView(
                    navController = navController,
                    name = stringResource(id = R.string.credit_agricole),
                    banks = state.CABanks,
                )
            }

            if (state.otherBanks.isNotEmpty()) {
                BanksView(
                    navController = navController,
                    name = stringResource(id = R.string.other_banks),
                    banks = state.otherBanks
                )
            }
        }
    } else {
        ErrorView(message = state.error)
    }
}
