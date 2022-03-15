package com.example.pokemon.module

import com.example.pokemon.repository.PokemonRepo
import com.example.pokemon.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class PokemonModuleDI {
    fun getModules() : Module {
        return module {
            single { PokemonRepo() }
            viewModel { PokemonViewModel(get()) }
        }
    }
}