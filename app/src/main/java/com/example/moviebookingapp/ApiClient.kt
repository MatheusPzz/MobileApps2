package com.example.moviebookingapp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private const val BASE_URL = "https://imdb-api.com/en/API/InTheaters/k_qqtgw9kj/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiInterface.ApiService = retrofit.create(ApiInterface.ApiService::class.java)
}