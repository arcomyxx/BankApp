package com.example.bankapp.domain.use_case

import com.example.bankapp.domain.models.Account
import com.example.bankapp.domain.models.Operation
import com.example.bankapp.domain.models.Resource
import com.example.bankapp.domain.repository.BanksRepository

class GetAccount(
    private val repository: BanksRepository,
) {
    suspend operator fun invoke(accountId: String): Resource<Account> = try {
        val account = repository.getAccountInfos(accountId)
        if (account != null) {
            Resource.Success(
                account.copy(
                    operations = account.operations.sortedWith(
                        compareByDescending<Operation> { it.date }.thenBy { it.title },
                    ),
                )
            )
        } else {
            Resource.Error("account not found")
        }
    } catch (e: Exception) {
        Resource.Error(e.message ?: "unknown error")
    }
}