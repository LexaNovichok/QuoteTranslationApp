package com.lexanovichok.quotetranslationapp.views.button

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.google.android.material.button.MaterialButton
import com.lexanovichok.quotetranslationapp.core.ProvideViewModel
import com.lexanovichok.quotetranslationapp.views.progress.CustomProgressPermanentState
import com.lexanovichok.quotetranslationapp.views.progress.CustomProgressSavedState

class CustomButton : MaterialButton, UpdateCustomButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun getFreezesText() = true

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val viewModel: CustomButtonViewModel =
            (context.applicationContext as ProvideViewModel).viewModel(CustomButtonViewModel::class.java)

        viewModel.liveData().observe(findViewTreeLifecycleOwner()!!) { uiState ->
            uiState.show(this)
        }

        setOnClickListener {
            viewModel.handleClick()
        }
    }

    override fun update(text: String, visible: Boolean) {
        setText(text)
        visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun onSaveInstanceState(): Parcelable {
        super.onSaveInstanceState().let {
            val state = CustomButtonSavedState(it)
            state.save(CustomButtonPermanentState(visibility))
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as CustomButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        val permanentState = restoredState.restore()
        visibility = permanentState.visibility
    }
}

interface UpdateCustomButton {

    fun update(text: String, visible: Boolean)
}