package com.example.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.login.R
import com.example.login.activity.LoginActivity
import com.example.login.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)

        binding.btnCriarconta.setOnClickListener {
            (activity as LoginActivity).setUpCreateFragment()
        }

        binding.tvEsqueci.setOnClickListener {
            (activity as LoginActivity).setUpEsqueciFragment()
        }

        return binding.root
    }




}