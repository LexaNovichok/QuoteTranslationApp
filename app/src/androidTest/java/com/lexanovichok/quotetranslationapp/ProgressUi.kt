package com.lexanovichok.quotetranslationapp

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.not
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

/**
 * Properties:
 * 1. visibility
 */
class ProgressUi(parentIdMatcher: Matcher<View>, parentClassMatcher: Matcher<View>) {

    @IdRes
    private val progressBarId : Int = R.id.progressBar
    private val interaction : ViewInteraction = onView(
        allOf(
            parentIdMatcher,
            parentClassMatcher,
            withId(progressBarId),
            isAssignableFrom(ProgressBar::class.java)
        )
    )

    fun checkInitialState() {
        interaction.check(matches(not(isDisplayed())))
    }

    fun checkProgressState() {
        interaction.check(matches(isDisplayed()))
    }

    fun waitTillGone() {
        onView(isRoot()).perform(waitTillNotDisplayed(progressBarId, 2000))
    }

    fun checkErrorState() {
        interaction.check(matches(not(isDisplayed())))
    }

    fun checkQuoteState() {
        interaction.check(matches(not(isDisplayed())))
    }

}
