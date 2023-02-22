package com.example.instagram.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagram.databinding.SingleFeedBinding
import com.example.instagram.models.Feed
import com.google.android.material.imageview.ShapeableImageView


class FeedAdapter(val context: Context?) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    private var feed: List<Feed> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding =  SingleFeedBinding.inflate(LayoutInflater.from(context), parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentItem = feed[position]
        Glide.with(context!!).load(currentItem.largeImageURL).into(holder.feedImage)
        holder.feedUsername.text = currentItem.id.toString()
    }

    override fun getItemCount(): Int {
        return feed.size
    }

    fun setFeeds(feeds: List<Feed>){
        this.feed = feeds
        notifyDataSetChanged()
    }
    class FeedViewHolder(binding: SingleFeedBinding) : RecyclerView.ViewHolder(binding.root) {
        val feedImage : ShapeableImageView = binding.feedImage
        val feedUsername : TextView = binding.feedProfileUsername
    }
}