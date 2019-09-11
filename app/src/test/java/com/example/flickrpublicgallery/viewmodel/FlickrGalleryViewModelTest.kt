package com.example.flickrpublicgallery.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.flickrpublicgallery.model.repository.FlickrGalleryRepository
import com.example.flickrpublicgallery.network.model.Status
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.MockitoAnnotations

/**
 * Created by Mudit Agarwal.
 */
class FlickrGalleryViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val flickrGalleryRepository: FlickrGalleryRepository = mock()

    private lateinit var flickrGalleryViewModel: FlickrGalleryViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        flickrGalleryViewModel = FlickrGalleryViewModel(flickrGalleryRepository)
    }

    @Test
    fun loadPhotos() {
        flickrGalleryViewModel.tagMutableLiveData.value = "abc"
        flickrGalleryViewModel.loadPhotos()

        Assert.assertEquals(flickrGalleryViewModel.getPhotoGalleryLiveData().value?.status, Status.SUCCESS)
        Assert.assertNotNull(flickrGalleryViewModel.getPhotoGalleryLiveData().value?.data)
    }
}