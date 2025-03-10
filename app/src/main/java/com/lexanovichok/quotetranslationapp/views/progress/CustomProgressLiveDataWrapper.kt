package com.lexanovichok.quotetranslationapp.views.progress

import com.lexanovichok.quotetranslationapp.core.LiveDataWrapper

interface CustomProgressLiveDataWrapper : LiveDataWrapper.Mutable<CustomProgressUiState> {

    class Base : CustomProgressLiveDataWrapper, LiveDataWrapper.Abstract<CustomProgressUiState>()
}