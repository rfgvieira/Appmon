package com.example.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.models.AbilityModel
import com.example.models.PokemonDetalhesModel
import com.example.models.PokemonModel
import com.example.pokemon.repository.PokemonRepo

class PokemonViewModel(private val repository : PokemonRepo) : ViewModel() {

    var pokemon = MutableLiveData<PokemonModel.Response>()
    var detalhe = MutableLiveData<PokemonDetalhesModel.Response>()
    var ability = MutableLiveData<AbilityModel.Reponse>()

    private var _abilityList = ArrayList<AbilityModel.Reponse>()
    var abilityList = MutableLiveData<ArrayList<AbilityModel.Reponse>>()



    private val pokemonListObserver = Observer<PokemonModel.Response> {
        pokemon.postValue(it)
    }

    private val pokemonDetalhesObserver = Observer<PokemonDetalhesModel.Response> {
        detalhe.postValue(it)
    }

    private val abilityObserver = Observer<AbilityModel.Reponse> {
        ability.postValue(it)
    }


    fun getPokemons() {
        repository.getPokemons()
        repository.pokemonList.observeForever(pokemonListObserver)
    }

    fun getPokemonId(){
        repository.pokemonId.value?.let { repository.getPokemonId(it) }

        repository.detalheList.observeForever(pokemonDetalhesObserver)
    }

    fun putPokemonValues(id : Int, name : String){
        repository.putPokemonValues(id,name)
    }

    fun getPokemonName() : String {
        return repository.pokemonName.value ?: ""
    }

    fun setAbilityList(ability: AbilityModel.Reponse) {
        repository.detalheList.value?.let {
            _abilityList.add(ability)

            if(_abilityList.size == it.abilities.size){
                abilityList.postValue(_abilityList)
            }
        }
    }

    fun getAbility() {
        repository.pokemonAbilities.observeForever(abilityObserver)

        repository.detalheList.value?.let {
            val abilityList : List<PokemonDetalhesModel.Ability> = it.abilities
            for (a in abilityList){
                val url = a.ability.url
                val cutStart = url.replace("https://pokeapi.co/api/v2/ability/", "")
                val id = cutStart.replace("/","").toInt()
                repository.getAbility(id)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        repository.pokemonList.removeObserver(pokemonListObserver)
        repository.detalheList.removeObserver(pokemonDetalhesObserver)
        repository.pokemonAbilities.removeObserver(abilityObserver)
    }
}