package com.example.pokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.models.PokemonModel
import com.example.pokemon.databinding.ItemPokemonBinding

class PokemonAdapter(private val context : Context, private val listPokemon : List<PokemonModel.Result>) :
    RecyclerView.Adapter<PokemonAdapter.PokeHolder>() {

    private lateinit var binding : ItemPokemonBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeHolder {
        binding = ItemPokemonBinding.inflate(LayoutInflater.from(context), parent, false)
        return PokeHolder()
    }

    override fun onBindViewHolder(holder: PokeHolder, position: Int) {
        val item = listPokemon[position]
        binding.tvNomepokemon.text = item.name
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = listPokemon.size

    inner class PokeHolder() : RecyclerView.ViewHolder(binding.root) { }
}