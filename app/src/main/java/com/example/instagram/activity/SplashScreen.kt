@file:Suppress("DEPRECATION")

package com.example.instagram.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.instagram.databinding.ActivitySplashScreenBinding


class SplashScreen : AppCompatActivity() {
    lateinit var binding : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.instaLogo.alpha = 0f
        binding.instaLogo.animate().apply {
            duration = 2000
            alpha(1f)
        }

        Handler().postDelayed({

            val inext : Intent

            if(logincheck()) {
                inext = Intent(this@SplashScreen, MainActivity::class.java)
            } else {

                if(obcheck()){
                    inext = Intent(this@SplashScreen, LoginActivity::class.java)
                } else {
                    inext = Intent(this@SplashScreen, OnBoardingScreen::class.java)
                }
            }
            startActivity(inext)
            finish()
        }, 3000)
    }

    private fun obcheck(): Boolean {
        val obpref = getSharedPreferences("OnBoarding", MODE_PRIVATE)
        return obpref.getBoolean("Finished", false)
    }

    private fun logincheck() : Boolean {

        val loginpref = getSharedPreferences("LoginActivity", MODE_PRIVATE)
        return loginpref.getBoolean("flag",false)

    }
}