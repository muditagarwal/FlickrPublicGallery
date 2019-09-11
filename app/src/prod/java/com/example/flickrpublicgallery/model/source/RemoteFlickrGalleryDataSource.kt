package com.example.flickrpublicgallery.model.source

import com.example.flickrpublicgallery.network.service.FlickrGalleryService

/**
 * Created by Mudit Agarwal.
 */
class RemoteFlickrGalleryDataSource(private val flickrGalleryService: FlickrGalleryService?) : FlickrGalleryDataSource {

    override suspend fun getPhotos(tag: String) = flickrGalleryService?.getPhotos(tag)
}