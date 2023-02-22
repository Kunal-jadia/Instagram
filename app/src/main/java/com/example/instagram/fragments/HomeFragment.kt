package com.example.instagram.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.adapters.FeedAdapter
import com.example.instagram.api.FeedService
import com.example.instagram.api.RetrofitHelper
import com.example.instagram.databinding.FragmentHomeBinding
import com.example.instagram.models.Feed
import com.example.instagram.models.TotalFeeds
import com.example.instagram.repository.FeedRepository
import com.example.instagram.viewModels.MainViewModel
import com.example.instagram.viewModels.MainViewModelFactory

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerView : RecyclerView
    lateinit var adapter: FeedAdapter
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val feedService = RetrofitHelper.getInstance().create(FeedService::class.java)
        val repository = FeedRepository(feedService)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.feeds.observe(this, Observer {feeds ->
            Log.d("Kunal", feeds.hits.toString())
        })

        //getFeed()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}

//    private fun getFeed() {
//        val feed = FeedService.feedInstance.getFeed()
//        feed.enqueue(object : Callback<TotalFeeds>{
//            override fun onResponse(call: Call<TotalFeeds>, response: Response<TotalFeeds>) {
//                val feed : TotalFeeds? = response.body()
//                if(feed!=null){
//                    Log.d("Kunal",feed.toString())
//                }
//            }
//
//            override fun onFailure(call: Call<TotalFeeds>, t: Throwable) {
//                Log.d("Kunal","Error in fetching data", t)
//            }
//        })
// }

//override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//    super.onViewCreated(view, savedInstanceState)
////        val liss = arrayListOf<Feed>()
////        val layoutManager = LinearLayoutManager(context)
////        recyclerView = binding.RVFeeds
////        recyclerView.layoutManager = layoutManager
////        recyclerView.setHasFixedSize(true)
////        adapter = FeedAdapter(context, liss)
////        recyclerView.adapter = adapter
//
//}