package com.lexanovichok.quotetranslationapp.quote.presentation.textactions

import com.lexanovichok.quotetranslationapp.R
import com.lexanovichok.quotetranslationapp.views.text.CustomTvUiState
import com.lexanovichok.quotetranslationapp.views.text.UpdateCustomTv

class HideTextAction : CustomTvUiState {

    override fun show(updateCustomTv: UpdateCustomTv) {
        updateCustomTv.update("", R.color.black)
    }
}