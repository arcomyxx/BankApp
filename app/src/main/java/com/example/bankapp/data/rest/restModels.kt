package com.example.bankapp.data.rest

import com.example.bankapp.domain.models.Account
import com.example.bankapp.domain.models.Bank
import com.example.bankapp.domain.models.Operation
import com.example.bankapp.domain.models.toBoolean
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

data class BankRest(
    val accounts: List<AccountRest>,
    val isCA: Int,
    val name: String
)

data class AccountRest(
    val balance: Double,
    val contractNumber: String?,
    val holder: String,
    val id: String,
    val label: String,
    val operations: List<OperationRest>,
    val order: Int,
    val productCode: String?,
    val role: Int,
)

data class OperationRest(
    val amount: String,
    val category: String,
    val date: String,
    val id: String,
    val title: String
)

fun BankRest.toDomain() = Bank(
    accounts = accounts.map(AccountRest::toDomain),
    isCA = isCA.toBoolean(),
    name = name,
)

fun AccountRest.toDomain() = Account(
    balance = balance,
    contractNumber = contractNumber,
    holder = holder,
    id = id,
    label = label,
    operations = operations.map(OperationRest::toDomain),
    order = order,
    productCode = productCode,
    role = role,
)

fun OperationRest.toDomain() = Operation(
    amount = amount,
    category = category,
    date = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.toLong()), ZoneId.of("UTC"))
        .toLocalDate(),
    id = id,
    title = title,
)
