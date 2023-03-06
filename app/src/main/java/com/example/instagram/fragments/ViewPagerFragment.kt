package com.example.instagram.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram.R
import com.example.instagram.adapters.ViewPagerAdapter


class ViewPagerFragment : Fragment() {
    private lateinit var viewpager : ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf(
            OBSFrag1(),
            OBSFrag2(),
            OBSFrag3()
        )

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        viewpager = view.findViewById(R.id.ViewPager)
        viewpager.adapter = adapter

        return view
    }

}