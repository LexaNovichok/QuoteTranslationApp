package com.lexanovichok.quotetranslationapp.views.text

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.lexanovichok.quotetranslationapp.core.ProvideViewModel
import com.lexanovichok.quotetranslationapp.views.progress.CustomProgressPermanentState
import com.lexanovichok.quotetranslationapp.views.progress.CustomProgressSavedState

class CustomTextView : androidx.appcompat.widget.AppCompatTextView, UpdateCustomTv {

    constructor(context : Context) : super(context)
    constructor(context : Context, attributeSet : AttributeSet) : super(context, attributeSet)
    constructor(context : Context, attributeSet : AttributeSet, defStyleAttrs : Int) : super(context, attributeSet, defStyleAttrs)

    override fun getFreezesText() = true

    override fun show(color: Int) {
        setTextColor(resources.getColor(color, null))
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val viewModel : CustomTvViewModel = (context.applicationContext as ProvideViewModel).viewModel(CustomTvViewModel::class.java)

        viewModel.liveData().observe(findViewTreeLifecycleOwner()!!) { uiState ->
             uiState.show(this)
        }
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = CustomTvSavedState(it)
            state.save(CustomTvPermanentState(visibility))
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as CustomTvSavedState
        super.onRestoreInstanceState(restoredState.superState)
        val permanentState = restoredState.restore()
        show(permanentState.color)
    }

}

interface UpdateCustomTv {
    fun show(@ColorRes color : Int)
}