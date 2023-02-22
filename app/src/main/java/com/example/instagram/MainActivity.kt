package com.example.instagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.instagram.api.FeedService
import com.example.instagram.databinding.ActivityMainBinding
import com.example.instagram.fragments.HomeFragment
import com.example.instagram.fragments.ProfileFragment
import com.example.instagram.fragments.SearchFragment
import com.example.instagram.models.TotalFeeds
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }
}