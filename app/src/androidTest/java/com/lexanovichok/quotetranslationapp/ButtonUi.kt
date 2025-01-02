package com.lexanovichok.quotetranslationapp

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.not
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

/**
 * Properties:
 * 1. text
 * 2. visibility
 */
class ButtonUi(parentIdMatcher: Matcher<View>, parentClassMatcher: Matcher<View>) {

    private val interaction : ViewInteraction = onView(
        allOf(
            parentIdMatcher,
            parentClassMatcher,
            withId(R.id.quoteButton),
            isAssignableFrom(Button::class.java)
        )
    )

    fun checkInitialState() {
        interaction.check(matches(isDisplayed()))
            .check(matches(withText("quote")))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }

    fun checkProgressState() {
        interaction.check(matches(not(isDisplayed())))
    }

    fun checkErrorState() {
        interaction.check(matches(isDisplayed()))
            .check(matches(withText("retry")))
    }

    fun checkQuoteState() {
        checkInitialState()
    }

}
