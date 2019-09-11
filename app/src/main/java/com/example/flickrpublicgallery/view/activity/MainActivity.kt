package com.example.flickrpublicgallery.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.flickrpublicgallery.R
import com.example.flickrpublicgallery.network.model.Status
import com.example.flickrpublicgallery.utils.Injection
import com.example.flickrpublicgallery.utils.observe
import com.example.flickrpublicgallery.viewmodel.FlickrGalleryViewModel
import com.example.flickrpublicgallery.viewmodel.factory.FlickrGalleryViewmodelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewmodel =
            ViewModelProvider(this, FlickrGalleryViewmodelFactory(Injection.provideFlickrGalleryRepository()))
                .get(FlickrGalleryViewModel::class.java)

        viewmodel.getPhotoGalleryLiveData().observe(this) {
            when (it?.status) {
                Status.LOADING -> Log.d("Mudit", "loading results")
                Status.ERROR -> Log.e("Mudit", "failure results ${it.throwable?.localizedMessage}", it.throwable)
                Status.SUCCESS -> Log.d("Mudit", "success results ${it.data?.items?.size}")
            }
        }

        viewmodel.tag.set("cat")
        viewmodel.loadPhotos()

    }
}
