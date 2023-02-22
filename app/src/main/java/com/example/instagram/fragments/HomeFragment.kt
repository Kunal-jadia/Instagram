package com.example.instagram.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagram.adapters.FeedAdapter
import com.example.instagram.api.FeedService
import com.example.instagram.api.RetrofitHelper
import com.example.instagram.databinding.FragmentHomeBinding
import com.example.instagram.repository.FeedRepository
import com.example.instagram.viewModels.MainViewModel
import com.example.instagram.viewModels.MainViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: FeedAdapter
    private var page : Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        val service = RetrofitHelper.getInstance().create(FeedService::class.java)
        val repository = FeedRepository(service)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository, page))[MainViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.RVFeeds.layoutManager = LinearLayoutManager(context)
        binding.RVFeeds.setHasFixedSize(true)
        adapter = FeedAdapter(context)
        binding.RVFeeds.adapter = adapter
        mainViewModel.feeds.observe(requireActivity()) {
            Log.d("Kunal", it.toString())
            adapter.setFeeds(it.hits)
        }
    }

}