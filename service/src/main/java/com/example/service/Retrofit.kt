package com.example.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFit {
    companion object{
        fun getRetrofitInstance() : Retrofit {
            return  Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}