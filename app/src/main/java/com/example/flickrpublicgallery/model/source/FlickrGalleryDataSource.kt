package com.example.flickrpublicgallery.model.source

import com.example.flickrpublicgallery.model.response.FlickrFeed

/**
 * Created by Mudit Agarwal.
 */
interface FlickrGalleryDataSource {

    suspend fun getPhotos(tag: String): FlickrFeed?
}