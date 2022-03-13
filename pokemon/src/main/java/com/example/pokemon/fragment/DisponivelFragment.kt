package com.example.pokemon.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokemon.databinding.FragmentDisponivelBinding
import com.example.pokemon.databinding.FragmentIndisponivelBinding

class DisponivelFragment : Fragment() {
    private lateinit var binding : FragmentDisponivelBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDisponivelBinding.inflate(inflater, container, false)
        return binding.root
    }
}