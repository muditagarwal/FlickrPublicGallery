package com.example.flickrpublicgallery.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickrpublicgallery.model.repository.FlickrGalleryRepository
import com.example.flickrpublicgallery.model.response.FlickrFeed
import com.example.flickrpublicgallery.network.model.Resource
import kotlinx.coroutines.runBlocking

/**
 * Created by Mudit Agarwal.
 */
class FlickrGalleryViewModel(private val flickrGalleryRepository: FlickrGalleryRepository) :
    ViewModel() {

    val tag = ObservableField("")
    private var photoGalleryLiveData: MutableLiveData<Resource<FlickrFeed>> = MutableLiveData()

    fun loadPhotos() {
        photoGalleryLiveData.value = Resource.loading()
        runBlocking {
            photoGalleryLiveData.value = try {
                Resource.success(flickrGalleryRepository.getPhotos(tag.get()!!) ?: FlickrFeed())
            } catch (exception: Exception) {
                Resource.error(exception)
            }
        }
    }

    fun getPhotoGalleryLiveData(): LiveData<Resource<FlickrFeed>> {
        return photoGalleryLiveData as LiveData<Resource<FlickrFeed>>
    }

}