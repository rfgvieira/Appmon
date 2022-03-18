package com.example.pokemon.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.models.PokemonModel
import com.example.pokemon.R
import com.example.pokemon.activity.PokemonActivity
import com.example.pokemon.adapter.PokemonAdapter
import com.example.pokemon.databinding.FragmentDisponivelBinding
import com.example.pokemon.databinding.FragmentIndisponivelBinding
import com.example.pokemon.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DisponivelFragment : Fragment() {
    private lateinit var binding : FragmentDisponivelBinding
    private val viewModel : PokemonViewModel by viewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        (activity as PokemonActivity).showPokeball()
        (activity as PokemonActivity).showText()
        (activity as PokemonActivity).showRedBall()

        binding = FragmentDisponivelBinding.inflate(inflater, container, false)
        viewModel.getPokemons()
        initObserver()
        return binding.root
    }


    private fun initObserver() {
        viewModel.pokemon.observe(viewLifecycleOwner){
            setUpAdapter(it.results)
        }
    }


    private fun setUpAdapter(list : List<PokemonModel.Result>?) {
        var adapter : PokemonAdapter? = null
        if(list != null){
            adapter = activity?.let { PokemonAdapter(it,list) }
        }
        binding.rvPokemons.adapter = adapter
        binding.rvPokemons.layoutManager =  LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.tvQuantidade.text = getString(R.string.quantidade) + list?.size.toString()
    }
}