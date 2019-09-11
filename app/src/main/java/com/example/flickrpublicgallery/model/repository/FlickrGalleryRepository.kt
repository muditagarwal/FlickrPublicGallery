package com.example.flickrpublicgallery.model.repository

import com.example.flickrpublicgallery.model.source.FlickrGalleryDataSource

/**
 * Created by Mudit Agarwal.
 */
class FlickrGalleryRepository(private val flickrGalleryDataSource: FlickrGalleryDataSource) : FlickrGalleryDataSource {

    override suspend fun getPhotos(tag: String) = flickrGalleryDataSource.getPhotos(tag)
}