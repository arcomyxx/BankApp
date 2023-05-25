package com.example.bankapp.presentation.view_models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bankapp.data.repository.BanksRepositoryImpl
import com.example.bankapp.domain.models.Bank
import com.example.bankapp.domain.models.Resource
import com.example.bankapp.domain.use_case.GetBanks
import kotlinx.coroutines.runBlocking

class MyAccountsViewModel : ViewModel() {
    private val adapter = BanksRepositoryImpl()
    private val getBanks = GetBanks(adapter)

    private val _state = mutableStateOf(AccountsState())
    val state: State<AccountsState> = _state

    init {
        getBankInfos()
    }

    private fun getBankInfos() {
        val resource = runBlocking { getBanks() }

        _state.value = when (resource) {
            is Resource.Success -> {
                val banks = resource.data
                val CABanks = banks?.let { list ->
                    list.filter { it.isCA }
                }
                val otherBanks = banks?.let { list ->
                    list.filterNot { it.isCA }
                }
                AccountsState(
                    CABanks = CABanks ?: emptyList(),
                    otherBanks = otherBanks ?: emptyList(),
                )
            }

            is Resource.Error -> AccountsState(error = resource.message)
        }
    }
}

data class AccountsState(
    val CABanks: List<Bank> = emptyList(),
    val otherBanks: List<Bank> = emptyList(),
    val error: String? = null
)
