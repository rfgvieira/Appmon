package com.example.pokemon.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.models.AbilityModel
import com.example.models.PokemonDetalhesModel
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

    private var _detalheList = MutableLiveData<PokemonDetalhesModel.Response>()
    val detalheList : LiveData<PokemonDetalhesModel.Response> = _detalheList

    private var _pokemonName = MutableLiveData<String>()
    val pokemonName : LiveData<String> = _pokemonName

    private var _pokemonId = MutableLiveData<Int>()
    val pokemonId : LiveData<Int> = _pokemonId

    private var _pokemonAbilities = MutableLiveData<AbilityModel.Reponse>()
    val pokemonAbilities : LiveData<AbilityModel.Reponse> = _pokemonAbilities

    private var _errorApi= MutableLiveData<Boolean>()
    val errorApi : LiveData<Boolean> = _errorApi

    fun getPokemons(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = endpoint.getPokemon(20)
            if(response.isSuccessful){
                val model = response.body()
                if(model != null)
                    _pokemonList.postValue(model)
                else
                   _errorApi.postValue(true)
            } else
                _errorApi.postValue(true)
        }
    }

    fun getPokemonId(id : Int){
        CoroutineScope(Dispatchers.IO).launch {
            val response = endpoint.getPokemonId(id)
            if(response.isSuccessful){
                val model = response.body()
                if(model != null)
                    _detalheList.postValue(model)
                else
                    _errorApi.postValue(true)
            } else
                _errorApi.postValue(true)
        }
    }

    fun getAbility(id : Int){
        CoroutineScope(Dispatchers.IO).launch {
            val response = endpoint.getAbility(id)
            if(response.isSuccessful){
                val model = response.body()
                if(model != null)
                    _pokemonAbilities.postValue(model)
                else
                    _errorApi.postValue(true)
            } else
                _errorApi.postValue(true)
        }
    }

    fun putPokemonValues(id : Int, name : String){
        _pokemonName.postValue(name)
        _pokemonId.postValue(id)
    }
}