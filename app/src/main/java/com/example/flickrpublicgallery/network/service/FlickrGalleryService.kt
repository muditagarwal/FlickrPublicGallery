package com.example.flickrpublicgallery.network.service

import com.example.flickrpublicgallery.model.response.FlickrFeed
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mudit Agarwal.
 */

const val FORMAT_TYPE = "json"
const val NO_JSON_CALLBACK_DEFAULT_VALUE = "1"

interface FlickrGalleryService {

    @GET("feeds/photos_public.gne")
    suspend fun getPhotos(
        @Query("tag") tag: String?,
        @Query("format") format: String = FORMAT_TYPE,
        @Query("nojsoncallback") noJsonCallback: String = NO_JSON_CALLBACK_DEFAULT_VALUE
    ): FlickrFeed
}