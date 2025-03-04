package com.lexanovichok.quotetranslationapp.views.button

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lexanovichok.quotetranslationapp.core.LiveDataWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class CustomButtonViewModel(
    private val handleAction : HandleAction,
    private val liveDataWrapper : CustomButtonLiveDataWrapper
) : ViewModel(), LiveDataWrapper.Read<CustomButtonUiState> {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    override fun liveData(): LiveData<CustomButtonUiState> = liveDataWrapper.liveData()

    fun handleClick() {
        handleAction.handle(viewModelScope)
    }

}