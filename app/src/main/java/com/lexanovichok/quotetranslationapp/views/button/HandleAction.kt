package com.lexanovichok.quotetranslationapp.views.button

import kotlinx.coroutines.CoroutineScope

interface HandleAction {

    fun handle(viewModelScope: CoroutineScope)


}