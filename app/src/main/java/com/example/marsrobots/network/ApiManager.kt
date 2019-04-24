package com.example.marsrobots.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
    fun service(): NasaService {
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://images-api.nasa.gov")
                .build()

        return retrofit.create(NasaService::class.java)
    }
}