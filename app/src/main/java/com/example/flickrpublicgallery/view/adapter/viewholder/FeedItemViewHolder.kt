package com.example.flickrpublicgallery.view.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.flickrpublicgallery.databinding.FeedItemBinding
import com.example.flickrpublicgallery.model.response.FeedItem

/**
 * Created by Mudit Agarwal.
 */
class FeedItemViewHolder(
    private val binding: FeedItemBinding,
    private val listener: ViewHolderListener
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            listener.showDetails(it.tag as FeedItem)
        }
    }

    fun bind(item: FeedItem) {
        binding.item = item
    }

    interface ViewHolderListener {
        fun showDetails(feedItem: FeedItem)
    }
}