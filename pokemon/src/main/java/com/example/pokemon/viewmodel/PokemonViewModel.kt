package com.example.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
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

    fun setAbilityList(ability: AbilityModel.Reponse) {
        repository.detalheList.value?.let {
            _abilityList.add(ability)
            if(_abilityList.size == it.abilities.size){
                abilityList.postValue(_abilityList)
            }
        }
    }

    fun getAbility() {

        repository.pokemonAbilities.observeForever {
            ability.postValue(it)
        }

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

//    fun getAbilityList() : List<PokemonDetalhesModel.Ability>{
//        return repository.pokemonAbilities.value ?: emptyList()
//    }


}