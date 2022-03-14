package com.example.login.module

import com.example.login.repository.LoginRepo
import com.example.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class LoginModuleDI {
    fun getModules() : Module {
        return module {
            single { LoginRepo() }
            viewModel { LoginViewModel(get()) }
        }
    }
}