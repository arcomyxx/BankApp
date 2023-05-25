package com.example.bankapp.data.rest

import retrofit2.Response
import retrofit2.http.*

interface  ApiService {
    @GET("/banks.json")
    suspend fun getBanks(): Response<List<BankRest>>
}
