package com.example.login.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.login.R
import com.example.login.databinding.FragmentCreateAccountBinding
import com.example.pokemon.activity.PokemonActivity

class CreateAccountFragment : Fragment() {
    private lateinit var binding : FragmentCreateAccountBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)

        binding.btnEntrarcriar.setOnClickListener {
            val intent = Intent(activity, PokemonActivity :: class.java)
            startActivity(intent)
        }

        return binding.root
    }
}