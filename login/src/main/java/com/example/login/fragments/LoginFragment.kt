package com.example.login.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.example.login.R
import com.example.login.activity.LoginActivity
import com.example.login.databinding.FragmentLoginBinding
import com.example.login.viewmodel.LoginViewModel
import com.example.pokemon.activity.PokemonActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private val viewmodel : LoginViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)

        binding.btnCriarconta.clMainbutton.setOnClickListener {
            (activity as LoginActivity).setUpCreateFragment()
        }

        binding.tvEsqueci.setOnClickListener {
            (activity as LoginActivity).setUpEsqueciFragment()
        }

        binding.iclButtonLogin.tvButton.text = getString(R.string.entrar)
        binding.iclButtonLogin.clButton.setOnClickListener {
            checkLogin()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as LoginActivity).setUpTitle(R.string.bemvindo)
    }

    private fun checkLogin() {
        with(binding){
            if(viewmodel.getAccount(edtUserlogin.text.toString(), edtSenhalogin.text.toString())){
                val intent = Intent(activity, PokemonActivity :: class.java)
                startActivity(intent)
            } else{
                binding.tvErrologin.visibility = View.VISIBLE
                binding.edtUserlogin.background =
                    activity?.let { AppCompatResources.getDrawable(it,R.drawable.roundedbackgrounderror) }
            }

        }
    }
}