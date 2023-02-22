package com.example.instagram.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.room.util.findColumnIndexBySuffix
import com.bumptech.glide.Glide
import com.example.instagram.R
import com.example.instagram.databinding.SingleFeedBinding
import com.example.instagram.models.Feed
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(val context: Context?, private val feed: List<Feed>) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
//        val binding = SingleFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return FeedViewHolder(binding)

        //val view = LayoutInflater.from(context).inflate(R.layout.single_feed, parent, false)
        return FeedViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.single_feed,
                parent,
            false))
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentItem = feed[position]
        Glide.with(context!!).load(currentItem.largeImageURL).into(holder.feedImage)
        holder.feedUsername.text = "Kunal Jadia"
    }

    override fun getItemCount(): Int {
        return feed.size
    }

    class FeedViewHolder(val binding: SingleFeedBinding) : RecyclerView.ViewHolder(binding.root) {
        val feedImage : ShapeableImageView = binding.feedImage
        val feedUsername : TextView = binding.feedProfileUsername
    }
}