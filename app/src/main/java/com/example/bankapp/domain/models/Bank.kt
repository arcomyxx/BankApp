package com.example.bankapp.domain.models

data class Bank(
    val accounts: List<Account>,
    val isCA: Boolean,
    val name: String
)