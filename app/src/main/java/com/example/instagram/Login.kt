package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instagram.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logBtn.setOnClickListener {
            val sharedpref = getSharedPreferences("Login", MODE_PRIVATE)
            val editor = sharedpref.edit()
            editor.putBoolean("flag",true)
            editor.apply()
            val switch_activity = Intent(this@Login, MainActivity::class.java)
            startActivity(switch_activity)
        }

        binding.logSignUp.setOnClickListener {
            val switch_activity = Intent(this, Register::class.java)
            startActivity(switch_activity)
        }
    }
}