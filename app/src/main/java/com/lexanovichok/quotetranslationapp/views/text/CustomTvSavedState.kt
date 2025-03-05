package com.lexanovichok.quotetranslationapp.views.text

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.annotation.ColorRes
import java.io.Serializable

class CustomTvSavedState : View.BaseSavedState {

    private lateinit var state : CustomTvPermanentState

    constructor(superState : Parcelable) : super(superState)

    private constructor(parcelIn : Parcel) : super(parcelIn) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            state = parcelIn.readSerializable(CustomTvPermanentState::class.java.classLoader, CustomTvPermanentState::class.java)!!
        } else {
            parcelIn.readSerializable() as CustomTvPermanentState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore() : CustomTvPermanentState = state

    fun save(uiState : CustomTvPermanentState) {
        state = uiState
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CustomTvSavedState> {
        override fun createFromParcel(parcel: Parcel): CustomTvSavedState =
            CustomTvSavedState(parcel)

        override fun newArray(size: Int): Array<CustomTvSavedState?> =
            arrayOfNulls(size)
    }
}

data class CustomTvPermanentState(@ColorRes val color: Int) : Serializable