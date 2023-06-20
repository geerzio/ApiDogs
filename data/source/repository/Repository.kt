package com.example.appi_application.data.source.repository

import com.example.appi_application.data.source.response.CatResponse
import com.example.appi_application.data.source.service.CarApi
import com.example.exampleretrofit2.data.source.service.RetrofitService
import retrofit2.Call

class Repository {

    private val retrofit : CarApi = RetrofitService.getInstance()

    fun getCarByBreed(breed:String): Call<CatResponse> {
        return retrofit.getCarByBreed( "$breed/images")
    }

}