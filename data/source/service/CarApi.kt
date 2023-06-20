package com.example.appi_application.data.source.service

import com.example.appi_application.data.source.response.CatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface CarApi {

    @GET
    fun getCarByBreed(@Url car:String):Call<CatResponse>

}