package com.example.instagram.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.instagram.repository.FeedRepository

class MainViewModelFactory(private val repository: FeedRepository, private val page : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository, page) as T
    }
}