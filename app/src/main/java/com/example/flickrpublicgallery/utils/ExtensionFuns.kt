package com.example.flickrpublicgallery.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

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

fun View.makeSnackBar(messageResId: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, messageResId, duration).show()
}

fun View.makeSnackBar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, duration).show()
}

fun Activity.hideKeyboard() {
    val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (currentFocus != null) {
        inputManager.hideSoftInputFromWindow(
            currentFocus?.windowToken, 0
        )
    }
}