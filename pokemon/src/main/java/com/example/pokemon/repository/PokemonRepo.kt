package com.example.pokemon.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.models.PokemonModel
import com.example.pokemon.Endpoint.Endpoint
import com.example.service.RetroFit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonRepo {
    val endpoint = RetroFit.getRetrofitInstance().create(Endpoint :: class.java)

    private var _pokemonList = MutableLiveData<PokemonModel.Response>()
    val pokemonList : LiveData<PokemonModel.Response> = _pokemonList

    fun getPokemons(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = endpoint.getPokemon(20)
            if(response.isSuccessful){
                val model = response.body()
                if(model != null)
                    _pokemonList.postValue(model)
                else
                    Log.d("nullApi","Api Nula")
            } else
                Log.d("falhou","Deu Ruim")
        }
    }
}