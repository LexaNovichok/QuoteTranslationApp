package com.lexanovichok.quotetranslationapp

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class withTextColor(private val color: Int) :
    BoundedMatcher<View, TextView>(TextView::class.java) {

    constructor(colorString: String) : this(Color.parseColor(colorString))

    override fun describeTo(description: Description) {
        description.appendText("color for button doesn't match expected $color")
    }

    override fun matchesSafely(item: TextView): Boolean {
        return item.currentTextColor == color
    }
}