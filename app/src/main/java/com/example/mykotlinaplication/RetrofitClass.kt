package com.example.mykotlinaplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClass {

    val URL_API: String
        get() = "https://pokeapi.co/api/v2/"

    fun acessar(): Retrofit {

        return Retrofit.Builder()
              .baseUrl(URL_API)
              .addConverterFactory(GsonConverterFactory.create())
              .build()
    }

}