package com.example.flickrpublicgallery.utils

import com.example.flickrpublicgallery.model.repository.FlickrGalleryRepository
import com.example.flickrpublicgallery.network.service.api.FlickrGalleryAPI
import retrofit2.Retrofit

/**
 * Created by Mudit Agarwal.
 */
interface Injector {

    //repo injectors
    fun provideFlickrGalleryRepository(): FlickrGalleryRepository

    // network related APIs
    fun provideRetrofit(baseUrl: String): Retrofit

    fun provideFlickrAPI(): FlickrGalleryAPI
}