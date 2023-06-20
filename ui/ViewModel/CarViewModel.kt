package com.example.appi_application.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appi_application.data.source.repository.Repository
import com.example.appi_application.data.source.response.CatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarViewModel: ViewModel() {

    private val repository = Repository()

    private val _car = MutableLiveData<List<String>>()
    val cars: LiveData<List<String>>get() = _car

    var message: String? = null

    fun getCarsByBreed(breed:String){
        repository.getCarByBreed(breed).enqueue(object:Callback<CatResponse>{
            override fun onResponse(call: Call<CatResponse>, response: Response<CatResponse>) {

                if(response.isSuccessful && response.body() != null){
                    _car.value = response.body()!!.image
                }

            }

            override fun onFailure(call: Call<CatResponse>, t: Throwable) {
                message = t.message
            }


        })
    }

}