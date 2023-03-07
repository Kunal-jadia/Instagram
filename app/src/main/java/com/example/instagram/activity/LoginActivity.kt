package com.example.instagram.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instagram.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logBtn.setOnClickListener {
            onLogged()
            val switchactivity = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(switchactivity)
        }

        binding.logSignUp.setOnClickListener {
            val switchactivity = Intent(this, RegisterActivity::class.java)
            startActivity(switchactivity)
        }
    }

    private fun onLogged(){
        val sharedpref = getSharedPreferences("LoginActivity", MODE_PRIVATE)
        val editor = sharedpref.edit()
        editor.putBoolean("flag",true)
        editor.apply()
    }
}