package com.lexanovichok.quotetranslationapp.quote.presentation.buttonactions

import com.lexanovichok.quotetranslationapp.R
import com.lexanovichok.quotetranslationapp.views.button.CustomButtonUiState
import com.lexanovichok.quotetranslationapp.views.button.UpdateCustomButton

class ShowQuoteAction : CustomButtonUiState {

    override fun show(updateCustomButton: UpdateCustomButton) {
        updateCustomButton.update(R.string.quote, true)
    }


}