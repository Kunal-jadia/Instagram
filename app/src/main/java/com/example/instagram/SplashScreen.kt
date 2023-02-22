@file:Suppress("DEPRECATION")

package com.example.instagram

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
            val sharedpref = getSharedPreferences("Login", MODE_PRIVATE)
            val editor = sharedpref.edit()
            val check: Boolean
            var inext : Intent
            editor.apply {
                check = sharedpref.getBoolean("flag",false)
                if(check){
                    inext = Intent(this@SplashScreen, MainActivity::class.java)
                } else {
                    inext = Intent(this@SplashScreen, Login::class.java)
                }
            }.apply()
            startActivity(inext)
        }, 3000)
    }
}