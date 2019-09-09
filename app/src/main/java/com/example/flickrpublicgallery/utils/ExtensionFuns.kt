package com.example.flickrpublicgallery.utils

import android.app.Activity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T?) -> Unit) = observe(owner,
    Observer<T> { v -> observer.invoke(v) })

fun TextView.text(): String {
    return text.toString().trim()
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun Activity.makeToast(messageResId: Int, toastLength: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, messageResId, toastLength).show()
}

fun Activity.makeToast(message: String, toastLength: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, toastLength).show()
}