package com.example.flickrpublicgallery.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.flickrpublicgallery.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Mudit Agarwal.
 */
class BindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("imageResUrl")
        fun setImageResourceUrl(imageView: ImageView, url: String?) {
            Glide.with(imageView.context)
                .load(url)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_placeholder_image)
                        .error(R.drawable.ic_placeholder_image)
                )
                .transition(DrawableTransitionOptions.withCrossFade())
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        (imageView.context as AppCompatActivity).startPostponedEnterTransition()
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        (imageView.context as AppCompatActivity).startPostponedEnterTransition()
                        return false
                    }
                })
                .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("publishedDate")
        fun setPublishedDate(textView: TextView, date: String) {
            val inputSimpleDateTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val outputSimpleDateTime = SimpleDateFormat("MMM dd,yyyy HH:mm:ss", Locale.getDefault())

            textView.text = textView.context.getString(
                R.string.published_date,
                outputSimpleDateTime.format(inputSimpleDateTime.parse(date)!!)
            )
        }

        @JvmStatic
        @BindingAdapter("dateTaken")
        fun setDateTaken(textView: TextView, date: String) {
            //2019-09-11T03:09:18-08:00
            val inputSimpleDateTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
            val convertedDate = inputSimpleDateTime.parse(date)
            var convertedDateStr = date
            convertedDate?.run {
                val dateTimeZone = TimeZone.getTimeZone("GMT${date.substring(date.lastIndexOf("-"))}")
                val offsetFromCurrentTimeZone = dateTimeZone.getOffset(time)
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = convertedDate.time
                calendar.timeZone = dateTimeZone

                convertedDateStr =
                    inputSimpleDateTime.format(Date(calendar.timeInMillis + offsetFromCurrentTimeZone - TimeZone.getDefault().rawOffset))
            }


            val outputSimpleDateTime = SimpleDateFormat("MMM dd,yyyy HH:mm:ss", Locale.getDefault())

            textView.text = textView.context.getString(
                R.string.date_taken,
                outputSimpleDateTime.format(
                    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(
                        convertedDateStr
                    )!!
                )
            )
        }

        @JvmStatic
        @BindingAdapter("html")
        fun setHtmlText(textView: TextView, text: String) {
            textView.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    }
}