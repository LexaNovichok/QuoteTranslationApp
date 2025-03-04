package com.lexanovichok.quotetranslationapp.views.text

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class CustomTextView : androidx.appcompat.widget.AppCompatTextView {

    constructor(context : Context) : super(context)
    constructor(context : Context, attributeSet : AttributeSet) : super(context, attributeSet)
    constructor(context : Context, attributeSet : AttributeSet, defStyleAttrs : Int) : super(context, attributeSet, defStyleAttrs)
}