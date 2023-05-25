package com.example.bankapp.data.repository

import com.example.bankapp.data.rest.ApiClient
import com.example.bankapp.data.rest.BankRest
import com.example.bankapp.data.rest.toDomain
import com.example.bankapp.domain.models.Account
import com.example.bankapp.domain.models.Bank
import com.example.bankapp.domain.repository.BanksRepository

class BanksRepositoryImpl : BanksRepository {
    override suspend fun getBanksInfos(): List<Bank> {
        val response = ApiClient.apiService.getBanks()
        val responseBody = response.body()

        if (response.isSuccessful && responseBody != null) {
            return responseBody.map(BankRest::toDomain)
        } else {
            throw Error(response.message())
        }
    }

    override suspend fun getAccountInfos(accountId: String): Account? {
        val response = ApiClient.apiService.getBanks()
        val responseBody = response.body()

        if (response.isSuccessful && responseBody != null) {
            return responseBody
                .flatMap { bank -> bank.accounts }
                .find { account -> account.id == accountId }
                ?.toDomain()
        } else {
            throw Error(response.message())
        }
    }
}