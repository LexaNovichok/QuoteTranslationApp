package com.lexanovichok.quotetranslationapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ScenarioText {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
      * Check initial state
      * Дейсвтие - 1. Click quote button
      * Результат - Check progress state
      * и тд также
      *
      * 2. Wait till progress gone
      * Check error state with text "No internet connection"
      *
      * 3. Click retry button
      * Check progress state
      *
      * 4. Wait till progress gone
      * Check quote state
      */

    private lateinit var quotePage : QuotePage
    @Before
    fun setUp() {
        val quotePage = QuotePage()
    }
    @Test
    fun caseNumber1() = with(quotePage) {
        checkInitialState()

        clickQuoteButton()
        checkProgressState()

        waitTillProgressGone()
        checkErrorState(message = "No internet connection")

        clickRetryButton()
        checkProgressState()

        waitTillProgressGone()
        checkQuoteState(quote = "Fake quote number 1")
    }
}