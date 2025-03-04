package com.lexanovichok.quotetranslationapp.views.button

import com.lexanovichok.quotetranslationapp.core.LiveDataWrapper

interface CustomButtonLiveDataWrapper : LiveDataWrapper.Mutable<CustomButtonUiState> {

    class Base : CustomButtonLiveDataWrapper, LiveDataWrapper.Abstract<CustomButtonUiState>()
}