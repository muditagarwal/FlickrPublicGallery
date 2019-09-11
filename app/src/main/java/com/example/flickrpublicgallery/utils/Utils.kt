package com.example.flickrpublicgallery.utils

import com.example.flickrpublicgallery.BuildConfig
import com.example.flickrpublicgallery.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

/**
 * Created by Mudit Agarwal.
 */

const val TIMEOUT = 60L

fun getOkHttpClient(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
        okHttpClientBuilder
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    }

    return okHttpClientBuilder.build()
}

fun Throwable.getDisplayMessage(): Int {
    return when (this) {
        is UnknownHostException -> R.string.error_no_internet
        else -> R.string.error_msg_generic
    }

}