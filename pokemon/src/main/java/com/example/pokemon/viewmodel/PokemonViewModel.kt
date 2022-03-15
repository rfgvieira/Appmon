package com.example.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.PokemonModel
import com.example.pokemon.repository.PokemonRepo

class PokemonViewModel(private val repository : PokemonRepo) : ViewModel() {

    var pokemon = MutableLiveData<PokemonModel.Response>()

    fun getPokemons() {
        repository.getPokemons()

        repository.pokemonList.observeForever {
            pokemon.postValue(it)
        }
    }



}