package com.example.flickrpublicgallery.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flickrpublicgallery.R
import com.example.flickrpublicgallery.model.response.FeedItem
import com.example.flickrpublicgallery.view.fragment.FeedItemDetailsFragment
import com.example.flickrpublicgallery.view.fragment.PhotoGalleryFragment
import com.jaeger.library.StatusBarUtil

class MainActivity : AppCompatActivity(), PhotoGalleryFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StatusBarUtil.setTransparent(this)
        StatusBarUtil.setLightMode(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PhotoGalleryFragment.newInstance()).commit()
    }

    override fun showDetails(feedItem: FeedItem) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, FeedItemDetailsFragment.newInstance(feedItem))
            .addToBackStack("details").commit()
    }
}
