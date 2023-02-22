package com.example.instagram.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.instagram.databinding.ActivityRegisterBinding
import com.example.instagram.db.UserDatabase
import com.example.instagram.models.UsersInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var database : UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = UserDatabase.getDatabase(this)
        binding.regRegBtn.setOnClickListener {

            val email = binding.regEmail.editText?.text.toString()
            val fullname = binding.regFullName.editText?.text.toString()
            val username = binding.regUserName.editText?.text.toString()
            val pass = binding.regPassword.editText?.text.toString()

            lifecycleScope.launch (Dispatchers.IO){
                database.userDao().addUser(UsersInfo(null,email,fullname,username,pass))
            }

//            val switch_activity = Intent(this, LoginActivity::class.java)
//            startActivity(switch_activity)
        }
    }
}