package com.example.bankapp.presentation.views.my_accounts.account_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bankapp.domain.models.Operation
import com.example.bankapp.presentation.view_models.AccountDetailsViewModel

@Composable
fun OperationItemView(
    operation: Operation,
    viewModel: AccountDetailsViewModel,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
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
                Column {
                    Text(
                        text = operation.title,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = viewModel.formatter.format(operation.date),
                        fontWeight = FontWeight.Bold,
                    )

                }
                Text(text = operation.amountWithUnit)
            }
        }
    }
}