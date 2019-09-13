package com.example.flickrpublicgallery.view

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Mudit Agarwal.
 */
class ItemOffsetDecoration(
    context: Context?,
    private val dividerHeight: Int,
    private var marginDirection: MarginDirection = MarginDirection.TOP,
    orientation: Int = VERTICAL
) :
    DividerItemDecoration(context, orientation) {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = 0
        outRect.right = 0
        outRect.bottom = 0
        outRect.top = 0

        when (marginDirection) {
            MarginDirection.LEFT -> outRect.left = dividerHeight
            MarginDirection.TOP -> outRect.top = dividerHeight
            MarginDirection.RIGHT -> outRect.right = dividerHeight
            MarginDirection.BOTTOM -> outRect.bottom = dividerHeight
        }
    }

    enum class MarginDirection {
        LEFT, TOP, RIGHT, BOTTOM
    }
}