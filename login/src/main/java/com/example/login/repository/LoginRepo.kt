package com.example.login.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

open class LoginRepo {
    private var _loginInfo = MutableLiveData<List<String>>()
    val loginInfo : LiveData<List<String>> = _loginInfo



    fun addAccount(account: List<String>) {
        _loginInfo.value = account
        val a = loginInfo.value
    }

}