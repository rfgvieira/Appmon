package com.example.login.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.login.R
import com.example.login.activity.LoginActivity
import com.example.login.databinding.FragmentCreateAccountBinding
import com.example.login.viewmodel.LoginViewModel
import com.example.pokemon.activity.PokemonActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateAccountFragment : Fragment() {
    private lateinit var binding : FragmentCreateAccountBinding
    private val viewmodel : LoginViewModel by viewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)

        binding.btnEntrarcriar.setOnClickListener {

            createAccount()
            (activity as LoginActivity).setUpLoginFragment()
        }

        return binding.root
    }

    fun createAccount() {
        with(binding){
            viewmodel.createAccount(edtNomecriar.text.toString(), edtUsuariocriar.text.toString(), edtDatanasccriar.text.toString(), edtEmailcriar.text.toString(), edtSenhacriar.text.toString())
        }
    }
}