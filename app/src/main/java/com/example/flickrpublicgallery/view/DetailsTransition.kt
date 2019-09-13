package com.example.flickrpublicgallery.view

import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.ChangeTransform
import androidx.transition.TransitionSet

/**
 * Created by Mudit Agarwal.
 */
class DetailsTransition : TransitionSet() {

    init {
        ordering = ORDERING_TOGETHER
        addTransition(ChangeBounds()).addTransition(ChangeTransform())
            .addTransition(ChangeImageTransform())
        duration = 800
    }
}