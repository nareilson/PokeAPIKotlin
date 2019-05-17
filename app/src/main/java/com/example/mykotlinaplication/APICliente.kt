package com.example.mykotlinaplication

import retrofit2.Call
import retrofit2.http.GET

interface APICliente {

    @GET("pokemon/")
    fun getPokerModel(): Call<ItemPoker>

//    @GET("pokemon/{name}")
//    abstract fun getPokemon(@Path("name") name: String): Call<PokerDescricao>
}