package com.example.pokemon.Endpoint

import com.example.models.PokemonModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {
    @GET("pokemon?")
    suspend fun getPokemon(@Query("limit") quant : Int) : Response<PokemonModel.Response>
}