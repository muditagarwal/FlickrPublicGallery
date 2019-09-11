package com.example.flickrpublicgallery.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flickrpublicgallery.databinding.FeedItemBinding
import com.example.flickrpublicgallery.model.response.FeedItem
import com.example.flickrpublicgallery.view.adapter.viewholder.FeedItemViewHolder

/**
 * Created by Mudit Agarwal.
 */
class FeedItemListAdapter(
    var items: List<FeedItem> = emptyList(),
    private val listener: FeedItemViewHolder.ViewHolderListener
) : RecyclerView.Adapter<FeedItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FeedItemViewHolder(
            FeedItemBinding.inflate(
                layoutInflater, parent, false
            ), listener
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateItems(items: List<FeedItem>) {
        this.items = items
        notifyDataSetChanged()
    }
}