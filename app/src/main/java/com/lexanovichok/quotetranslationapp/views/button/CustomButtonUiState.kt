package com.lexanovichok.quotetranslationapp.views.button

import android.view.View
import com.lexanovichok.quotetranslationapp.databinding.ActivityMainBinding

interface CustomButtonUiState {

    fun show(updateCustomButton: UpdateCustomButton)

    object Initial : CustomButtonUiState {
        override fun show(updateCustomButton: UpdateCustomButton) {
            TODO("Not yet implemented")
        }


    }

    object Loading : CustomButtonUiState {
        override fun show(updateCustomButton: UpdateCustomButton) {
            TODO("Not yet implemented")
        }

    }

    data class Error(private val errorText : String) : CustomButtonUiState {
        override fun show(updateCustomButton: UpdateCustomButton) {
            TODO("Not yet implemented")
        }


    }
}