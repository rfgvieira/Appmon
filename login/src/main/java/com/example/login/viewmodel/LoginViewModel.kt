package com.example.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.login.repository.LoginRepo

class LoginViewModel(private val repository : LoginRepo) : ViewModel() {



    fun createAccount(nome : String, user : String, dataNasc : String, email : String, senha : String){
        val account = listOf(nome,user,dataNasc,email,senha)
        repository.addAccount(account)
    }

    fun getAccount(user :String, pass: String) : Boolean{
        if(user == repository.loginInfo.value?.get(1) ?: false && pass == repository.loginInfo.value?.get(4) ?: false)
            return true
        return false
    }
}