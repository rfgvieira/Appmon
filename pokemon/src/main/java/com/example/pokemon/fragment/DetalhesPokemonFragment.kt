package com.example.pokemon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemon.R
import com.example.pokemon.activity.PokemonActivity
import com.example.pokemon.databinding.FragmentDetalhesPokemonBinding


class DetalhesPokemonFragment : Fragment() {
   private lateinit var binding: FragmentDetalhesPokemonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as PokemonActivity).hideRedBall()
        binding = FragmentDetalhesPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }
}