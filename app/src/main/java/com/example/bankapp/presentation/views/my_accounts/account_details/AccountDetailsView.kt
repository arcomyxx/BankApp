package com.example.bankapp.presentation.views.my_accounts.account_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bankapp.presentation.view_models.AccountDetailsViewModel
import com.example.bankapp.presentation.views.common.ErrorView

@Composable
fun AccountDetailsView(
    accountId: String?,
    viewModel: AccountDetailsViewModel = AccountDetailsViewModel(),
) {
    if(accountId != null) {
        val accountState = viewModel.getAccountInfos(accountId)

        if(accountState.error == null) {
            val account = accountState.account

            if (account != null) {
                Column {
                    Text(
                        text = account.balanceWithUnit,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                            .padding(20.dp),
                    )

                    Text(
                        text = account.label,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                            .padding(10.dp),
                    )

                    LazyColumn {
                        items(account.operations) { operation ->
                            OperationItemView(operation = operation, viewModel = viewModel)
                        }
                    }
                }
            }
        } else {
            ErrorView(message = accountState.error)
        }
    }
}