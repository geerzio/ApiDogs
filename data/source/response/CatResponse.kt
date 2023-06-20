package com.example.appi_application.data.source.response

import android.hardware.lights.LightState
import com.google.gson.annotations.SerializedName

data class CatResponse(


    @SerializedName("message")
    val image: List<String>,
    val status: String

)