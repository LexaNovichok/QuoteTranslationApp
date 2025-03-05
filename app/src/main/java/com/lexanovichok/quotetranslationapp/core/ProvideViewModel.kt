package com.lexanovichok.quotetranslationapp.core

import androidx.lifecycle.ViewModel
import com.lexanovichok.quotetranslationapp.views.button.CustomButtonLiveDataWrapper
import com.lexanovichok.quotetranslationapp.views.button.CustomButtonViewModel

interface ProvideViewModel {

    fun <T : ViewModel> viewModel(clasz : Class<T>) : T

    class Base : ProvideViewModel {

        private val customButtonLiveDataWrapper = CustomButtonLiveDataWrapper.Base()

        override fun <T : ViewModel> viewModel(clasz: Class<T>): T {
            return when(clasz) {
                CustomButtonViewModel::class.java -> CustomButtonViewModel(customButtonLiveDataWrapper)

                else -> throw IllegalStateException("unknown viewModelClass $clasz")
            } as T
        }

    }
}