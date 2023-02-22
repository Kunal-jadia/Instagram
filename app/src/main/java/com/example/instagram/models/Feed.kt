package com.example.instagram.models

data class Feed(
    val id: Int,
    val largeImageURL: String,
    val views: Int,
    val likes: Int,
    val comments: Int,
    val type: String
    //val collections: Int,
    //val downloads: Int,
    //val imageHeight: Int,
    //val imageSize: Int,
    //val imageWidth: Int,
    //val pageURL: String,
    //val previewHeight: Int,
    //val previewURL: String,
    //val previewWidth: Int,
    //val tags: String,
    //val user: String,
    //val userImageURL: String,
    //val user_id: Int,
    //val webformatHeight: Int,
    //val webformatURL: String,
    //val webformatWidth: Int
)