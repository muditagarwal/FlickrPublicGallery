package com.example.flickrpublicgallery.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.flickrpublicgallery.R
import com.example.flickrpublicgallery.databinding.FeedItemDetailsBinding
import com.example.flickrpublicgallery.model.response.FeedItem

private const val ARG_FEED_ITEM = "feedItem"

/**
 * A simple [Fragment] subclass for showing details of Feed Item
 *
 */
class FeedItemDetailsFragment : Fragment() {

    private lateinit var binding: FeedItemDetailsBinding
    private var feedItem: FeedItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            feedItem = it.getParcelable(ARG_FEED_ITEM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed_item_details, container, false)
        postponeEnterTransition()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.item = feedItem!!
    }

    companion object {
        fun newInstance(feedItem: FeedItem) =
            FeedItemDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_FEED_ITEM, feedItem)
                }
            }
    }
}
