package com.example.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.base.BaseActivity
import com.example.login.R
import com.example.login.databinding.ActivityLoginBinding
import com.example.login.fragments.CreateAccountFragment
import com.example.login.fragments.EsqueciFragment
import com.example.login.fragments.LoginFragment

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpLoginFragment()

    }

     fun setUpLoginFragment() {
         binding.tvTitlelogin.text = getString(R.string.bemvindo)
         val loginFragment = LoginFragment()
         supportFragmentManager.beginTransaction()
            .replace(R.id.fl_login,loginFragment,"Login")
            .commit()
    }

     fun setUpCreateFragment() {
         binding.tvTitlelogin.text = getString(R.string.informacoes)
        val createFragment = CreateAccountFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_login,createFragment,"Create")
            .commit()
    }

    fun setUpEsqueciFragment(){
        binding.tvTitlelogin.text = getString(R.string.esqsenha)
        val esqueciFragment = EsqueciFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_login,esqueciFragment,"Esqueci")
            .commit()
    }
}