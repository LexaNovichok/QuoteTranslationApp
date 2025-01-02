package com.lexanovichok.quotetranslationapp

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher

class QuotePage {

    private val parentIdMatcher : Matcher<View> = withParent(withId(R.id.rootLayout))
    private val parentClassMatcher : Matcher<View> = withParent(isAssignableFrom(LinearLayout::class.java))

    private val textUi = TextUi(parentIdMatcher = parentIdMatcher, parentClassMatcher = parentClassMatcher)
    private val buttonUi = ButtonUi(parentIdMatcher = parentIdMatcher, parentClassMatcher = parentClassMatcher)
    private val progressUi = ProgressUi(parentIdMatcher = parentIdMatcher, parentClassMatcher = parentClassMatcher)

    fun checkInitialState() {
        textUi.checkInitialState()
        buttonUi.checkInitialState()
        progressUi.checkInitialState()
    }

    fun clickQuoteButton() {
        buttonUi.click()
    }

    fun checkProgressState() {
        textUi.checkProgressState()
        buttonUi.checkProgressState()
        progressUi.checkProgressState()
    }

    fun waitTillProgressGone() {
        progressUi.waitTillGone()
    }

    fun checkErrorState(message: String) {
        textUi.checkErrorState(message = message)
        buttonUi.checkErrorState()
        progressUi.checkErrorState()
    }

    fun clickRetryButton() {
        buttonUi.click()
    }

    fun checkQuoteState(quote: String) {
        textUi.checkQuoteState(quote = quote)
        buttonUi.checkQuoteState()
        progressUi.checkQuoteState()
    }

}
