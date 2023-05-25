package com.example.bankapp.presentation.view_models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bankapp.domain.models.Bank
import java.text.DecimalFormat

class BankItemViewModel(
    val bank: Bank,
) : ViewModel() {
    private val balanceFormat = DecimalFormat("#.##")
    val expandedSate = mutableStateOf(false)
    val balance = "${balanceFormat.format(bank.accounts.sumOf { it.balance })} €"
}