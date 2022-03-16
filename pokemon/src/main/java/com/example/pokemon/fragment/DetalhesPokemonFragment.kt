package com.example.pokemon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.models.PokemonDetalhesModel
import com.example.pokemon.activity.PokemonActivity
import com.example.pokemon.adapter.DetalhesAdapter
import com.example.pokemon.databinding.FragmentDetalhesPokemonBinding
import com.example.pokemon.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetalhesPokemonFragment : Fragment() {
   private lateinit var binding: FragmentDetalhesPokemonBinding
   private val viewModel : PokemonViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as PokemonActivity).hideRedBall()
        binding = FragmentDetalhesPokemonBinding.inflate(inflater, container, false)
        initObserver()

        binding.iclCard.tvPokename.text = viewModel.getPokemonName()
        binding.iclTitledetalhepokemon.imvBackarrow.setOnClickListener {
            (activity as PokemonActivity).showRedBall()
            (activity as PokemonActivity).showText()
            (activity as PokemonActivity).showPokeball()
            (activity as PokemonActivity).onBackPressed()
        }

        viewModel.getPokemonId()
        return binding.root
    }

    private fun initObserver() {
        viewModel.detalhe.observe(viewLifecycleOwner){
            setUpAdapter(it)
        }
    }

    private fun setUpAdapter(list : PokemonDetalhesModel.Response) {
        val names = listOf("Ability", "Forms", "Game Indices", "Moves",
            "Species", "Sprites", "Status")
        val adapter = activity?.let { DetalhesAdapter(list, names, it) }

        binding.iclCard.rvDetalhes.adapter = adapter
        binding.iclCard.rvDetalhes.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }
}