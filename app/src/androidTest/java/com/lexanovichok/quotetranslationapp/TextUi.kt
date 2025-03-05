package com.lexanovichok.quotetranslationapp

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

/**
 * Properties:
 * 1. color
 * 2. text
 */
class TextUi(parentIdMatcher: Matcher<View>, parentClassMatcher: Matcher<View>) {

    private val interaction : ViewInteraction = onView(
        allOf(
            parentIdMatcher,
            parentClassMatcher,
            withId(R.id.quoteTextView),
            isAssignableFrom(TextView::class.java)
        )
    )

    fun checkInitialState() {
        interaction.check(matches(withText("")))
    }

    fun checkProgressState() {
        interaction.check(matches(withText("")))
    }

    fun checkErrorState(message: String) {
        interaction
            .check(matches(withText(message)))
            .check(matches(withTextColor(R.color.red)))
    }

    fun checkQuoteState(quote: String) {
        interaction
            .check(matches(withText(quote)))
            .check(matches(withTextColor(R.color.black)))
    }

}
