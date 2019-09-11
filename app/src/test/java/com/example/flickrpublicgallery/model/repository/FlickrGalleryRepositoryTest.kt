package com.example.flickrpublicgallery.model.repository

import com.example.flickrpublicgallery.model.source.FlickrGalleryDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Mudit Agarwal.
 */
class FlickrGalleryRepositoryTest {

    private lateinit var flickrGalleryRepository: FlickrGalleryRepository

    @Mock
    private lateinit var flickrGalleryDataSource: FlickrGalleryDataSource

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        flickrGalleryRepository = FlickrGalleryRepository(flickrGalleryDataSource)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getPhotos() {
        runBlockingTest {
            flickrGalleryRepository.getPhotos("")

            Mockito.verify<FlickrGalleryDataSource>(flickrGalleryDataSource).getPhotos(
                anyString()
            )
        }
    }
}