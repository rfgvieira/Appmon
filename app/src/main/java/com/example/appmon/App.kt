package com.example.appmon

import android.app.Application
import com.example.login.module.LoginModuleDI
import com.example.pokemon.module.PokemonModuleDI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        val listModules = listOf(
            LoginModuleDI().getModules(),
            PokemonModuleDI().getModules()
        )

        startKoin {
            androidContext(this@App)
            modules(listModules)
        }
    }
}