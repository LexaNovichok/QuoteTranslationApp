package com.lexanovichok.quotetranslationapp.quote.presentation.progressactions

import com.lexanovichok.quotetranslationapp.views.progress.CustomProgressUiState
import com.lexanovichok.quotetranslationapp.views.progress.UpdateCustomProgress

class ShowProgressAction : CustomProgressUiState {

    override fun show(updateCustomProgress: UpdateCustomProgress) {
        updateCustomProgress.update(true)
    }
}