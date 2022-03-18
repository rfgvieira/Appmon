package com.example.pokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.models.PokemonDetalhesModel
import com.example.pokemon.R
import com.example.pokemon.activity.PokemonActivity
import com.example.pokemon.databinding.ItemTabelaPokemonBinding

class DetalhesAdapter(private val pokeInfo: PokemonDetalhesModel.Response,
                      private val listElements: List<String>,
                      private val context : Context
) : RecyclerView.Adapter<DetalhesAdapter.DetalhesHolder>(){
    private lateinit var binding : ItemTabelaPokemonBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetalhesHolder {
        binding = ItemTabelaPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetalhesHolder()
    }

    override fun onBindViewHolder(holder: DetalhesHolder, position: Int) {
        val item = listElements[position]
        if(position % 2 == 0)
            binding.llTableItem.setBackgroundColor(ContextCompat.getColor(context,R.color.lightdarkgray))
        else
            binding.llTableItem.setBackgroundColor(ContextCompat.getColor(context,R.color.gray))

        binding.tvQtd.text = getType(item).toString()
        binding.tvName.text = item
        binding.tvDetalheslink.setOnClickListener {
            clickDetalhes(position)
        }
    }

    private fun clickDetalhes(pos : Int) {
        if(pos == 0){
            (context as PokemonActivity).setUpHabilidadesFragment()
        }
        else
            (context as PokemonActivity).setUpIndisponivelFragment()
    }

    private fun getType(item : String) : Int {
        when(item){
            "Ability" -> return pokeInfo.abilities.size
            "Forms" -> return pokeInfo.forms.size
            "Game Indices" -> return pokeInfo.gameIndices.size
            "Moves" -> return pokeInfo.moves.size
            "Species" -> return 1
            "Sprites" -> return 1
            "Status" -> return pokeInfo.stats.size
        }
        return 0
    }

    override fun getItemCount(): Int = listElements.size

    inner class DetalhesHolder() : RecyclerView.ViewHolder(binding.root){ }
}