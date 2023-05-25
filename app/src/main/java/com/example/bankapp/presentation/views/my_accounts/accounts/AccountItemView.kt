package com.example.bankapp.presentation.views.my_accounts.accounts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bankapp.domain.models.Account
import com.example.bankapp.presentation.navigation.ID_ARG
import com.example.bankapp.presentation.navigation.MyAccountsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountItemView(
    account: Account,
    navController: NavHostController,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            navController.navigate("${MyAccountsScreen.Details.route}?$ID_ARG=${account.id}")
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = account.label)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = account.balanceWithUnit)
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "arrow right",
                        modifier = Modifier.padding(start = 10.dp),
                    )
                }
            }
        }
    }
}