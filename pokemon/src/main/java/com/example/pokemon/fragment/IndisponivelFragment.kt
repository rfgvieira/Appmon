package com.example.pokemon.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokemon.activity.PokemonActivity
import com.example.pokemon.databinding.FragmentIndisponivelBinding

class IndisponivelFragment : Fragment() {
    private lateinit var binding: FragmentIndisponivelBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as PokemonActivity).showPokeball()
        (activity as PokemonActivity).showText()
        (activity as PokemonActivity).showRedBall()

        binding = FragmentIndisponivelBinding.inflate(inflater, container, false)
        return binding.root
    }
}