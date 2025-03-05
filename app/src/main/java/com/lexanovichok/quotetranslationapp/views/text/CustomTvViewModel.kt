package com.lexanovichok.quotetranslationapp.views.text

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lexanovichok.quotetranslationapp.core.LiveDataWrapper

class CustomTvViewModel(
    private val liveDataWrapper : CustomTVLiveDataWrapper
) : ViewModel(), LiveDataWrapper.Read<CustomTvUiState> {

    override fun liveData(): LiveData<CustomTvUiState> = liveDataWrapper.liveData()

}