package com.example.instagram.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.fragments.ViewPagerFragment

class OnBoardingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_screen)

        replaceFragment(ViewPagerFragment())
    }

    private fun replaceFragment(fragment : Fragment){

        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.fragmentContainerView,fragment)
        fragTransaction.commit()

        //supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }
}