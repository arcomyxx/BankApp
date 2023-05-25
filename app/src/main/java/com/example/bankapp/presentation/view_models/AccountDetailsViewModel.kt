package com.example.bankapp.presentation.view_models

import androidx.lifecycle.ViewModel
import com.example.bankapp.data.repository.BanksRepositoryImpl
import com.example.bankapp.domain.models.Account
import com.example.bankapp.domain.models.Resource
import com.example.bankapp.domain.use_case.GetAccount
import kotlinx.coroutines.runBlocking
import java.time.format.DateTimeFormatter

class AccountDetailsViewModel : ViewModel() {
    private val adapter = BanksRepositoryImpl()
    private val getAccount = GetAccount(adapter)

    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    fun getAccountInfos(accountId: String) =
        when (val resource = runBlocking { getAccount(accountId) }) {
            is Resource.Success -> AccountState(account = resource.data)
            is Resource.Error -> AccountState(error = resource.message)
        }
}

data class AccountState(
    val account: Account? = null,
    val error: String? = null
)
