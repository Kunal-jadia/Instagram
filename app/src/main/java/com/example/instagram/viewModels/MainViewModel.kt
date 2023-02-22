package com.example.instagram.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagram.models.Feed
import com.example.instagram.models.TotalFeeds
import com.example.instagram.repository.FeedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: FeedRepository ) : ViewModel() {
    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getFeed()
        }
    }

    val feeds : LiveData<TotalFeeds>
    get() = repository.feeds
}