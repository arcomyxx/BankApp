package com.example.bankapp.domain.use_case

import com.example.bankapp.domain.models.Bank
import com.example.bankapp.domain.models.Resource
import com.example.bankapp.domain.repository.BanksRepository

class GetBanks(
    private val repository: BanksRepository,
) {
    suspend operator fun invoke(): Resource<List<Bank>> = try {
        val banks = repository.getBanksInfos()
        Resource.Success(banks.sortedBy { it.name })
    } catch (e: Exception) {
        Resource.Error(e.message ?: "unknown error")
    }
}