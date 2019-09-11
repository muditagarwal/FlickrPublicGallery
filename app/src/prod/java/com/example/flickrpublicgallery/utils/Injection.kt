package com.example.flickrpublicgallery.utils

import com.example.flickrpublicgallery.model.repository.FlickrGalleryRepository
import com.example.flickrpublicgallery.model.source.RemoteFlickrGalleryDataSource
import com.example.flickrpublicgallery.network.service.api.FlickrGalleryAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mudit Agarwal.
 */
object Injection : Injector {

    override fun provideFlickrGalleryRepository(): FlickrGalleryRepository {
        return FlickrGalleryRepository(RemoteFlickrGalleryDataSource(provideFlickrAPI().getFlickrGalleryService()))
    }

    override fun provideRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient()).build()
    }

    override fun provideFlickrAPI() = FlickrGalleryAPI

}