package com.example.flickrpublicgallery.view.fragment

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.flickrpublicgallery.R
import com.example.flickrpublicgallery.testutils.clickChildViewWithId
import com.example.flickrpublicgallery.view.activity.MainActivity
import com.example.flickrpublicgallery.view.adapter.viewholder.FeedItemViewHolder
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Mudit Agarwal.
 */

@RunWith(AndroidJUnit4::class)
class FeedItemDetailUITest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testUIVisibility() {
        Espresso.onView(withId(R.id.photos)).perform(
            RecyclerViewActions.actionOnItemAtPosition<FeedItemViewHolder>(
                0,
                clickChildViewWithId(R.id.feedItemCard)
            )
        )

        onView(withId(R.id.feedItemPhoto)).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.feedItemTitle), withText("Test Photo"))).check(matches(isDisplayed()))
        onView(
            allOf(
                withId(R.id.feedItemPublishedDate),
                withText(activityRule.activity.getString(R.string.published_date, "Sep 11,2019 10:09:16"))
            )
        ).check(matches(isDisplayed()))
        onView(
            allOf(
                withId(R.id.dateTaken),
                withText(activityRule.activity.getString(R.string.date_taken, "Sep 10,2019 13:13:26"))
            )
        ).check(matches(isDisplayed()))
        onView(
            allOf(
                withId(R.id.author),
                withText(activityRule.activity.getString(R.string.author, "nobody@flickr.com"))
            )
        ).check(matches(isDisplayed()))
        onView(
            allOf(
                withId(R.id.tags),
                withText(activityRule.activity.getString(R.string.tags, "random"))
            )
        ).check(matches(isDisplayed()))
    }
}