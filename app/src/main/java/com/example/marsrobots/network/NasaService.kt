package com.example.marsrobots.network

import retrofit2.Call
import retrofit2.http.GET

interface NasaService {
    @GET("/search?q=mars&media_type=image")
    fun getListImages(): Call<MarsImagesResponse>
}