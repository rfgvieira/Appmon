package com.example.login.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import com.example.base.BaseActivity
import com.example.login.databinding.ActivityLoginBinding
import com.example.login.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cont = this
        val timer = object : CountDownTimer(2500,1000){
            override fun onTick(p0: Long) { }
            override fun onFinish() {
                val intent = Intent(cont ,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}