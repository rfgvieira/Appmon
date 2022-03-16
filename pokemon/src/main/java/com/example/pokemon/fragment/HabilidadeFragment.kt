package com.example.pokemon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemon.R
import com.example.pokemon.databinding.FragmentHabilidadeBinding
import com.example.pokemon.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HabilidadeFragment : Fragment() {

    private lateinit var binding : FragmentHabilidadeBinding
    private val viewModel : PokemonViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHabilidadeBinding.inflate(inflater, container, false)
        return binding.root
    }

}