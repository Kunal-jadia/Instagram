package com.example.instagram.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram.R

class OBSFrag2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_obs_frag2, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.ViewPager)

        val next = view.findViewById<Button>(R.id.OBS2_btn)
        next.setOnClickListener {
            viewPager?.currentItem = 2
        }

        return view
    }

}