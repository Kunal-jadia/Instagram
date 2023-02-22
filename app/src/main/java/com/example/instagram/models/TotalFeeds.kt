package com.example.instagram.models

data class TotalFeeds(
    val hits: List<Feed>,
    val total: Int,
    val totalHits: Int
)