package com.example.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
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

    fun showRedBall(){
        binding.imvBolavermelha.visibility = View.VISIBLE
    }

    fun showWhiteBall(){
        binding.imvBolabranca.visibility = View.VISIBLE
    }

    fun redBackground(){
        binding.root.setBackgroundColor(ContextCompat.getColor(this,R.color.red))
    }

    fun normalBackground(){
        binding.root.setBackgroundColor(ContextCompat.getColor(this,R.color.gray))
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount

        if(count <= 1)
            super.onBackPressed()
        else
            supportFragmentManager.popBackStack()
    }

}