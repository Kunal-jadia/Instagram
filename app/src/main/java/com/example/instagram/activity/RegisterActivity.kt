package com.example.instagram.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.instagram.databinding.ActivityRegisterBinding
import com.example.instagram.db.UserDatabase
import com.example.instagram.models.UsersInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
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

            if(isEmailvalid(email) && isFullnamevalid(fullname) && isUsernamevalid(username) && isPasswordvalid(pass) && isCheckbox()){
                lifecycleScope.launch (Dispatchers.IO){
                    database.userDao().addUser(UsersInfo(null,email,fullname,username,pass))
                }
                Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show()
                clearFields()
            }
        }

        binding.regLogIn.setOnClickListener {
            val switchActivity = Intent(this, LoginActivity::class.java)
            startActivity(switchActivity)
        }
    }

    private fun isPasswordvalid(pass: String): Boolean {

        if(pass.isEmpty()){
            binding.regPassword.error = "Field can't be empty"
            return false
        } else {
            binding.regPassword.error = null
            return true
        }
    }

    private fun isUsernamevalid(username: String): Boolean {
        if(username.isEmpty()){
            binding.regUserName.error = "Enter username"
            return false
        } else {
            binding.regUserName.error = null
            return true
        }
    }

    private fun isEmailvalid(email: String): Boolean {

        if(email.isEmpty()){
            binding.regEmail.error = "Field can't be empty"
            return false
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.regEmail.error = "Please enter a valid email address"
            return false
        } else {
            binding.regEmail.error = null
            return true
        }
    }

    private fun isFullnamevalid(fullname: String): Boolean {

        if (fullname.isEmpty()){
            binding.regFullName.error = "Enter name"
            return false
        } else {
            binding.regFullName.error = null
            return true
        }
    }

    private fun isCheckbox(): Boolean {
        if(binding.regCheckBox.isChecked){
            return true
        }
        return false
    }

    private fun clearFields() {
        binding.regEmail.editText?.text?.clear()
        binding.regFullName.editText?.text?.clear()
        binding.regUserName.editText?.text?.clear()
        binding.regPassword.editText?.text?.clear()
        binding.regCheckBox.isChecked = false
    }
}