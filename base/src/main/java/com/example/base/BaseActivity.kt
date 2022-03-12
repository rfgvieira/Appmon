package com.example.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.base.databinding.ActivityBaseBinding

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
    }

    override fun setContentView(view: View) {
        binding.flBase.addView(view)
        super.setContentView(binding.root)
    }

    fun hideRedBall(){
        binding.imvBolavermelha.visibility = View.GONE
    }

    fun hideWhiteBall(){
        binding.imvBolabranca.visibility = View.GONE
    }

}