package com.example.flickrpublicgallery.view.fragment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.flickrpublicgallery.R
import com.example.flickrpublicgallery.testutils.atPositionOnView
import com.example.flickrpublicgallery.view.activity.MainActivity
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Mudit Agarwal.
 */

@RunWith(AndroidJUnit4::class)
class PhotoGalleryUITest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testUIVisibilityOfListScreen() {
        testViewVisibility("Test Photo", "Sep 11,2019 10:09:16")
    }

    @Test
    fun testUIVisibilityOfListScreenWithDateTakenSorting() {
        onView(withId(R.id.action_sort)).perform(click())
        onView(allOf(withId(R.id.title), withText(R.string.sort_by_date_taken))).perform(click())
        testViewVisibility("First in Date Taken", "Sep 11,2019 10:10:14")
    }

    @Test
    fun testUIVisibilityOfListScreenWithPublishedDateSorting() {
        onView(withId(R.id.action_sort)).perform(click())
        onView(allOf(withId(R.id.title), withText(R.string.sort_by_published_date))).perform(click())
        testViewVisibility("First in Published Date", "Sep 11,2019 10:10:17")
    }

    private fun testViewVisibility(title: String, date: String) {
        onView(withId(R.id.photos)).check(matches(isDisplayed()))
        onView(withId(R.id.photos))
            .check(
                matches(
                    atPositionOnView(
                        0,
                        withText(title),
                        R.id.title
                    )
                )
            )

        onView(withId(R.id.photos))
            .check(
                matches(
                    atPositionOnView(
                        0,
                        withText(activityRule.activity.getString(R.string.published_date, date)),
                        R.id.date
                    )
                )
            )
    }
}