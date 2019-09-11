package com.example.flickrpublicgallery.utils

import com.example.flickrpublicgallery.network.service.api.BASE_URL
import org.junit.Assert
import org.junit.Test

/**
 * Created by Mudit Agarwal.
 */
class InjectionTest {

    @Test
    fun provideFlickrGalleryRepository() {
        Assert.assertNotNull(Injection.provideFlickrGalleryRepository())
    }

    @Test
    fun provideRetrofit() {
        Assert.assertNotNull(Injection.provideRetrofit(BASE_URL))
    }

    @Test
    fun provideFlickrAPI() {
        Assert.assertNotNull(Injection.provideFlickrAPI())
    }
}