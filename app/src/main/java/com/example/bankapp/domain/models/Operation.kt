package com.example.bankapp.domain.models

import java.time.LocalDate

data class Operation(
    val amount: String,
    val category: String,
    val date: LocalDate,
    val id: String,
    val title: String
) {
    val amountWithUnit = "$amount €"
}