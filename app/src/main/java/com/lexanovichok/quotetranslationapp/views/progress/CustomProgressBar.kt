package com.lexanovichok.quotetranslationapp.views.progress

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.lexanovichok.quotetranslationapp.core.ProvideViewModel
import com.lexanovichok.quotetranslationapp.views.button.CustomButtonViewModel

class CustomProgressBar : ProgressBar, UpdateCustomProgress {

    constructor(context : Context) : super(context)
    constructor(context : Context, attributeSet : AttributeSet) : super(context, attributeSet)
    constructor(context : Context, attributeSet : AttributeSet, defStyleAttrs : Int) : super(context, attributeSet, defStyleAttrs)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val viewModel : CustomProgressViewModel = (context.applicationContext as ProvideViewModel).viewModel(
            CustomProgressViewModel::class.java)

        viewModel.liveData().observe(findViewTreeLifecycleOwner()!!) { uiState ->
            uiState.show(this)
        }
    }

    override fun update(visible: Boolean) {
        visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun onSaveInstanceState(): Parcelable? {
         return super.onSaveInstanceState()?.let {
             val state = CustomProgressSavedState(it)
             state.save(CustomProgressPermanentState(visibility))
             return state
         }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as CustomProgressSavedState
        super.onRestoreInstanceState(restoredState.superState)
        val permanentState = restoredState.restore()
        this.visibility = permanentState.visibility

    }
}

interface UpdateCustomProgress {
    fun update(visible : Boolean)
}