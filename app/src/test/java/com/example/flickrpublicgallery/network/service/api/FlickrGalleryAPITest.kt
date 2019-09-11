package com.example.flickrpublicgallery.network.service.api

import org.junit.Assert
import org.junit.Test

/**
 * Created by Mudit Agarwal.
 */
class FlickrGalleryAPITest {

    @Test
    fun getFlickrGalleryService() {
        Assert.assertNotNull(FlickrGalleryAPI)
        Assert.assertNotNull(FlickrGalleryAPI.getFlickrGalleryService())
    }
}