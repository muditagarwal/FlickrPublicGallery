package com.example.flickrpublicgallery.network.service.api

import com.example.flickrpublicgallery.network.service.FlickrGalleryService
import com.example.flickrpublicgallery.utils.Injection

/**
 * Created by Mudit Agarwal.
 */

const val BASE_URL = "https://www.flickr.com/services/"

object FlickrGalleryAPI : FlickrGalleryAPIInterface {

    private val service: FlickrGalleryService? =
        Injection.provideRetrofit(BASE_URL).create(FlickrGalleryService::class.java)

    override fun getFlickrGalleryService() = service
}

interface FlickrGalleryAPIInterface {
    fun getFlickrGalleryService(): FlickrGalleryService?
}

