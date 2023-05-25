package com.example.bankapp.domain.repository

import com.example.bankapp.domain.models.Account
import com.example.bankapp.domain.models.Bank

interface BanksRepository {
    suspend fun getBanksInfos(): List<Bank>
    suspend fun getAccountInfos(accountId: String): Account?
}