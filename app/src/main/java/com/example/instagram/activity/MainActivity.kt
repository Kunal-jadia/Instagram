package com.example.instagram.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.databinding.ActivityMainBinding
import com.example.instagram.fragments.HomeFragment
import com.example.instagram.fragments.ProfileFragment
import com.example.instagram.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {replaceFragment(HomeFragment())}
                R.id.search -> {replaceFragment(SearchFragment())}
                R.id.profile -> {replaceFragment(ProfileFragment())}
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.frameLayout,fragment)
        fragTransaction.commit()

        //supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }
}