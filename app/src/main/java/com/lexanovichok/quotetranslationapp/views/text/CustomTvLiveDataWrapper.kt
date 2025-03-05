package com.lexanovichok.quotetranslationapp.views.text

import com.lexanovichok.quotetranslationapp.core.LiveDataWrapper

interface CustomTVLiveDataWrapper : LiveDataWrapper.Mutable<CustomTvUiState> {

    class Base : CustomTVLiveDataWrapper, LiveDataWrapper.Abstract<CustomTvUiState>()
}