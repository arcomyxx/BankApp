package com.example.bankapp.presentation.views.my_accounts.banks

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bankapp.domain.models.Bank

@Composable
fun BanksView(
    navController: NavHostController,
    name: String,
    banks: List<Bank>,
) {
    Text(
        text = name,
        style = MaterialTheme.typography.labelMedium,
        modifier = Modifier.padding(10.dp),
    )

    if (banks.isNotEmpty()) {
        LazyColumn {
            items(banks) { bank ->
                BankItemView(bank = bank, navController = navController)
            }
        }
    }
}