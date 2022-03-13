package com.example.pokemon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.base.BaseActivity
import com.example.pokemon.R
import com.example.pokemon.databinding.ActivityPokemonBinding
import com.example.pokemon.fragment.DisponivelFragment
import com.example.pokemon.fragment.IndisponivelFragment

class PokemonActivity : BaseActivity() {
    private lateinit var binding : ActivityPokemonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        hideWhiteBall()
        setContentView(binding.root)

        setUpIndisponivelFragment()
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
            .commit()
    }
}