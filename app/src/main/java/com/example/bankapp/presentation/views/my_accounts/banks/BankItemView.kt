package com.example.bankapp.presentation.views.my_accounts.banks

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bankapp.domain.models.Bank
import com.example.bankapp.presentation.view_models.BankItemViewModel
import com.example.bankapp.presentation.views.my_accounts.accounts.AccountItemView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BankItemView(
    bank: Bank,
    navController: NavHostController,
    viewModel: BankItemViewModel = BankItemViewModel(bank),
) {
    var expandedState by remember {
        viewModel.expandedSate
    }

    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f,
        label = "Rotation state of expand icon button",
    )

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = bank.name)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = viewModel.balance)
                    IconButton(
                        modifier = Modifier
                            .rotate(rotationState)
                            .padding(start = 10.dp),
                        onClick = { expandedState = !expandedState }
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "dropdown arrow",
                        )
                    }
                }
            }
        }

        if (expandedState) {
            Column(
                modifier = Modifier.padding(start = 30.dp),
            ) {
                bank.accounts.forEach { account ->
                    AccountItemView(account = account, navController = navController)
                }
            }
        }
    }
}