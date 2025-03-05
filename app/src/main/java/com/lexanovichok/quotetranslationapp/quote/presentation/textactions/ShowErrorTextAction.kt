package com.lexanovichok.quotetranslationapp.quote.presentation.textactions

import com.lexanovichok.quotetranslationapp.R
import com.lexanovichok.quotetranslationapp.views.text.CustomTvUiState
import com.lexanovichok.quotetranslationapp.views.text.UpdateCustomTv

data class ShowErrorTextAction(private val value : String) : CustomTvUiState {

    override fun show(updateCustomTv: UpdateCustomTv) {
        updateCustomTv.update(value, R.color.red)
    }
}