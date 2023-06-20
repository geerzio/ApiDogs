package com.example.exampleretrofit2.data.source.service

import com.example.appi_application.data.source.service.CarApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitService {

    @Volatile
    private var INSTANCE: CarApi? = null // Singleton


    fun getInstance(): CarApi {
        synchronized(this) {
            return INSTANCE ?: buildService().also {
                INSTANCE = it
            }
        }
    }


    // Instancia Retrofit y Interfaz con los metodos HTTP
    private fun buildService(): CarApi {
        //val url = "https://rickandmortyapi.com/api/"
        //val url = "https://api.themoviedb.org/3/"

        val url = "https://dog.ceo/api/breeds/"

        val httpClient: OkHttpClient.Builder =
            OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)// Maneja el timeout




        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())// parsea de Json a Gson para manejar la respuesta como clases de Kotlin
            .build()


        return retrofit.create(CarApi::class.java)
    }


}