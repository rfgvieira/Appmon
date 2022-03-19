package com.example.pokemon.activity

import android.os.Bundle
import android.view.View
import com.example.base.BaseActivity
import com.example.models.PokemonDetalhesModel
import com.example.pokemon.R
import com.example.pokemon.databinding.ActivityPokemonBinding
import com.example.pokemon.fragment.DetalhesPokemonFragment
import com.example.pokemon.fragment.DisponivelFragment
import com.example.pokemon.fragment.HabilidadeFragment
import com.example.pokemon.fragment.IndisponivelFragment
import com.example.pokemon.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonActivity : BaseActivity() {
    private lateinit var binding : ActivityPokemonBinding
    private val viewModel : PokemonViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        hideWhiteBall()
        setContentView(binding.root)

        setUpDisponivelFragment()
    }

    fun setUpDisponivelFragment(){
        binding.tvTitlepokemon.text = getString(R.string.disponivel)
        val dispFragment = DisponivelFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_pokemon,dispFragment,"Disponivel")
            .commit()
    }

    fun setUpIndisponivelFragment(){
        binding.tvTitlepokemon.text = getString(R.string.indisponivel)
        val indispFragment = IndisponivelFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_pokemon,indispFragment,"Indisponivel")
            .addToBackStack(null)
            .commit()
    }

    fun setUpDetalhesFragment(id : Int, name : String){
        viewModel.putPokemonValues(id,name)
        val detalheFragment = DetalhesPokemonFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_pokemon,detalheFragment,"Detalhes")
            .addToBackStack(null)
            .commit()
    }

    fun setUpHabilidadesFragment() {
        val habilidadesFragment = HabilidadeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_pokemon,habilidadesFragment,"Habilidades")
            .addToBackStack(null)
            .commit()
    }

    fun removePokeball(){
        binding.imvPokeballpoke.visibility = View.GONE
    }

    fun removeText(){
        binding.tvTitlepokemon.visibility = View.GONE
    }

    fun showPokeball(){
        binding.imvPokeballpoke.visibility = View.VISIBLE
    }

    fun showText(){
        binding.tvTitlepokemon.visibility = View.VISIBLE
    }
}