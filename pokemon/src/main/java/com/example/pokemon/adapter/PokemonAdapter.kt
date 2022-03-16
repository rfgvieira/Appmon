package com.example.pokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.models.PokemonModel
import com.example.pokemon.activity.PokemonActivity
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
        val name : String = item.name[0].uppercaseChar().toString() + item.name.substring(1)
        binding.iclItempoke.tvTexto.text = name

        binding.iclItempoke.imvRedarrowdetalhe.setOnClickListener {
            val id = getIdFromUrl(item.url)
            (context as PokemonActivity).setUpDetalhesFragment(id,name)
        }
    }

    private fun getIdFromUrl(url: String): Int {
        val cutStart = url.replace("https://pokeapi.co/api/v2/pokemon/", "")
        return cutStart.replace("/","").toInt()
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int = position

    override fun getItemCount(): Int = listPokemon.size

    inner class PokeHolder() : RecyclerView.ViewHolder(binding.root) { }
}