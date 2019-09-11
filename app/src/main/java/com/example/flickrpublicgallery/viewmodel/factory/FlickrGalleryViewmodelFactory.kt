package com.example.flickrpublicgallery.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flickrpublicgallery.model.repository.FlickrGalleryRepository

/**
 * Created by Mudit Agarwal.
 */
class FlickrGalleryViewmodelFactory(val flickrGalleryRepository: FlickrGalleryRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(FlickrGalleryRepository::class.java).newInstance(flickrGalleryRepository)
    }
}