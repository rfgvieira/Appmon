package com.example.appmon

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {

        }
    }
}