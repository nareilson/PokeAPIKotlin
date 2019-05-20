package com.example.mykotlinaplication

import com.example.mykotlinaplication.Descricao.DescricaoPoker
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APICliente {

    @GET("pokemon/")
    fun getPokerModel(): Call<ItemPoker>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Call<DescricaoPoker>
}