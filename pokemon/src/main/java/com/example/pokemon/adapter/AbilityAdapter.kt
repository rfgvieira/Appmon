package com.example.pokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.models.AbilityModel
import com.example.pokemon.databinding.ItemAbilityBinding

class AbilityAdapter(private val context: Context, private val listAbility: ArrayList<AbilityModel.Reponse>) :
RecyclerView.Adapter<AbilityAdapter.AbilityHolder>() {

    private lateinit var binding : ItemAbilityBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityHolder {
        binding = ItemAbilityBinding.inflate(LayoutInflater.from(context), parent, false)
        return AbilityHolder()
    }

    override fun onBindViewHolder(holder: AbilityHolder, position: Int) {
        val item = listAbility[position]
        binding.titleAbility.text = item.names[7].name
        binding.abilityDesc.text = item.effectEntries[1].effect + "\n(" + item.effectEntries[1].shortEffect + ")"
    }



    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int = position

    override fun getItemCount(): Int = listAbility.size

    inner class AbilityHolder() : RecyclerView.ViewHolder(binding.root) { }

}