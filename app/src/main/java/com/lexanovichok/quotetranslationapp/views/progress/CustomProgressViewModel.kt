package com.lexanovichok.quotetranslationapp.views.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lexanovichok.quotetranslationapp.core.LiveDataWrapper

class CustomProgressViewModel(
    private val liveDataWrapper: CustomProgressLiveDataWrapper
) : ViewModel(), LiveDataWrapper.Read<CustomProgressUiState> {

    override fun liveData(): LiveData<CustomProgressUiState> = liveDataWrapper.liveData()

}
