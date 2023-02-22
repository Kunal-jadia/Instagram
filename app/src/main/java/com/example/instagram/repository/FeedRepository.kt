package com.example.instagram.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instagram.api.FeedService
import com.example.instagram.models.Feed
import com.example.instagram.models.TotalFeeds

class FeedRepository(private val feedService: FeedService) {


    private val feedLiveData = MutableLiveData<TotalFeeds>()

    val feeds : LiveData<TotalFeeds>
    get() = feedLiveData

    suspend fun getFeed(){
        val result = feedService.getFeed()
        if(result?.body() != null){
            feedLiveData.postValue(result.body())
        }
    }
}