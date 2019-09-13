package com.example.flickrpublicgallery.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickrpublicgallery.model.repository.FlickrGalleryRepository
import com.example.flickrpublicgallery.model.response.FlickrFeed
import com.example.flickrpublicgallery.network.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Mudit Agarwal.
 */
class FlickrGalleryViewModel(private val flickrGalleryRepository: FlickrGalleryRepository) :
    ViewModel() {

    val dataLoading = ObservableBoolean(false)
    val tagMutableLiveData = MutableLiveData("")
    private var photoGalleryLiveData: MutableLiveData<Resource<FlickrFeed>> = MutableLiveData()

    fun loadPhotos() {
        dataLoading.set(true)
        val resource: Resource<FlickrFeed> = runBlocking(Dispatchers.IO) {
            try {
                Resource.success(flickrGalleryRepository.getPhotos(tagMutableLiveData.value!!) ?: FlickrFeed())
            } catch (exception: Exception) {
                Resource.error<FlickrFeed>(exception)
            }
        }
        photoGalleryLiveData.value = resource
        dataLoading.set(false)
    }

    fun loadPhotosForATag(tag: String) {
        tagMutableLiveData.value = tag
        loadPhotos()
    }

    fun resetSearch() {
        tagMutableLiveData.value = ""
        loadPhotos()
    }

    fun getPhotoGalleryLiveData(): LiveData<Resource<FlickrFeed>> {
        return photoGalleryLiveData as LiveData<Resource<FlickrFeed>>
    }

    fun sortByDateTaken() {
        val sortedItemList =
            photoGalleryLiveData.value?.data?.items?.sortedByDescending {
                //2019-09-10T12:21:58-08:00
                val simpleDateTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault())
                simpleDateTime.parse(it.dateTaken)?.time
            }
        photoGalleryLiveData.value = Resource.success(FlickrFeed(sortedItemList!!))
    }

    fun sortByDatePublished() {
        val sortedItemList =
            photoGalleryLiveData.value?.data?.items?.sortedByDescending {
                //2019-09-11T09:24:49Z
                val simpleDateTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
                simpleDateTime.parse(it.published)?.time
            }
        photoGalleryLiveData.value = Resource.success(FlickrFeed(sortedItemList!!))
    }
}