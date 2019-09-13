package com.example.flickrpublicgallery.view.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.flickrpublicgallery.model.response.FeedItem
import com.example.flickrpublicgallery.view.DetailsTransition
import com.example.flickrpublicgallery.view.fragment.FeedItemDetailsFragment
import com.example.flickrpublicgallery.view.fragment.PhotoGalleryFragment
import com.jaeger.library.StatusBarUtil


class MainActivity : AppCompatActivity(), PhotoGalleryFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.flickrpublicgallery.R.layout.activity_main)

        StatusBarUtil.setTransparent(this)
        StatusBarUtil.setLightMode(this)

        supportFragmentManager.beginTransaction()
            .replace(com.example.flickrpublicgallery.R.id.container, PhotoGalleryFragment.newInstance()).commit()
    }

    override fun showDetails(
        feedItem: FeedItem,
        photoImageView: ImageView,
        titleTextView: TextView,
        publishedDateTextView: TextView
    ) {

        val feedItemDetailsFragment = FeedItemDetailsFragment.newInstance(feedItem)
        feedItemDetailsFragment.sharedElementEnterTransition = DetailsTransition()
        feedItemDetailsFragment.sharedElementReturnTransition = DetailsTransition()

        supportFragmentManager.beginTransaction()
            .add(com.example.flickrpublicgallery.R.id.container, feedItemDetailsFragment)
            .addSharedElement(photoImageView, "SHARED_TRANSITION_PHOTO")
            .addSharedElement(titleTextView, "SHARED_TRANSITION_TITLE")
            .addSharedElement(publishedDateTextView, "SHARED_TRANSITION_PUB_DATE")
            .addToBackStack("details").commit()
    }
}
