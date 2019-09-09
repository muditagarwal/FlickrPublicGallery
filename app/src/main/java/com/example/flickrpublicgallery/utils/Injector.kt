package com.example.flickrpublicgallery.utils

import android.content.Context
import com.example.flickrpublicgallery.model.repository.FlickrGalleryRepository
import com.example.flickrpublicgallery.network.service.FlickrGalleryAPI
import retrofit2.Retrofit

/**
 * Created by Mudit Agarwal.
 */
interface Injector {

    //repo injectors
    fun provideUserRepository(context: Context): FlickrGalleryRepository

    // network related APIs
    fun provideRetrofit(baseUrl: String): Retrofit

    fun provideLoginAPI(baseUrl: String): FlickrGalleryAPI
}