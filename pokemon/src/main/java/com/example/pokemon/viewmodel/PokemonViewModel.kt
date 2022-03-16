package com.example.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.PokemonDetalhesModel
import com.example.models.PokemonModel
import com.example.pokemon.repository.PokemonRepo

class PokemonViewModel(private val repository : PokemonRepo) : ViewModel() {

    var pokemon = MutableLiveData<PokemonModel.Response>()
    var detalhe = MutableLiveData<PokemonDetalhesModel.Response>()



    fun getPokemons() {
        repository.getPokemons()
        repository.pokemonList.observeForever {
            pokemon.postValue(it)
        }
    }

    fun getPokemonId(){
        repository.pokemonId.value?.let { repository.getPokemonId(it) }

        repository.detalheList.observeForever {
            detalhe.postValue(it)
        }
    }

    fun putPokemonValues(id : Int, name : String){
        repository.putPokemonValues(id,name)
    }

    fun getPokemonName() : String {
        return repository.pokemonName.value ?: ""
    }



}