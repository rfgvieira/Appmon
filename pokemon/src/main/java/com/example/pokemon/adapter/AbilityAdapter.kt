package com.example.pokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.models.AbilityModel
import com.example.pokemon.databinding.ItemAbilityBinding

class AbilityAdapter(private val context: Context, private val listAbility: ArrayList<AbilityModel.Reponse>, private val language : Int) :
RecyclerView.Adapter<AbilityAdapter.AbilityHolder>() {

    private lateinit var binding : ItemAbilityBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityHolder {
        binding = ItemAbilityBinding.inflate(LayoutInflater.from(context), parent, false)
        return AbilityHolder()
    }

    override fun onBindViewHolder(holder: AbilityHolder, position: Int) {
        val item = listAbility[position]
        binding.titleAbility.text = item.names[7].name
        binding.abilityDesc.text = verifyLanguage(item.effectEntries)
    }

    private fun verifyLanguage(item: List<AbilityModel.EffectEntry>): String {
        for (a in item){
            if(language == 0 && a.language.name == "en"){
                return a.effect + "\n(" + a.shortEffect  + ")"
            } else if(language == 1 && a.language.name == "de"){
                return a.effect + "\n(" + a.shortEffect  + ")"
            }
        }
        return ""
    }




    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int = position

    override fun getItemCount(): Int = listAbility.size

    inner class AbilityHolder() : RecyclerView.ViewHolder(binding.root) { }

}