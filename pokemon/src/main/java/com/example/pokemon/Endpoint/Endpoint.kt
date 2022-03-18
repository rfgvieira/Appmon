package com.example.pokemon.Endpoint

import com.example.models.AbilityModel
import com.example.models.PokemonDetalhesModel
import com.example.models.PokemonModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {
    @GET("pokemon?")
    suspend fun getPokemon(@Query("limit") quant : Int) : Response<PokemonModel.Response>

    @GET("pokemon/{id}")
    suspend fun getPokemonId(@Path("id") id : Int) : Response<PokemonDetalhesModel.Response>

    @GET("ability/{id}")
    suspend fun getAbility(@Path("id") id : Int) : Response<AbilityModel.Reponse>
}