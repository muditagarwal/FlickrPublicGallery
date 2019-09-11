package com.example.flickrpublicgallery.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mudit Agarwal.
 */
data class FlickrFeed(var items: List<FeedItem> = emptyList())

@Parcelize
data class FeedItem(
    val title: String,
    val link: String,
    val media: Media,
    @SerializedName("date_taken") val dateTaken: String,
    val description: String,
    val published: String,
    val author: String,
    @SerializedName("author_id") val authorId: String,
    val tags: String
) : Parcelable


@Parcelize
data class Media(val m: String) : Parcelable