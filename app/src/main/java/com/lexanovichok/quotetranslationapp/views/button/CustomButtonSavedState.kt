package com.lexanovichok.quotetranslationapp.views.button

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.annotation.ColorRes
import java.io.Serializable

class CustomButtonSavedState : View.BaseSavedState {

    private lateinit var state : CustomButtonPermanentState

    constructor(superState : Parcelable) : super(superState)

    private constructor(parcelIn : Parcel) : super(parcelIn) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            state = parcelIn.readSerializable(CustomButtonPermanentState::class.java.classLoader, CustomButtonPermanentState::class.java)!!
        } else {
            parcelIn.readSerializable() as CustomButtonPermanentState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore() : CustomButtonPermanentState = state

    fun save(uiState : CustomButtonPermanentState) {
        state = uiState
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CustomButtonSavedState> {
        override fun createFromParcel(parcel: Parcel): CustomButtonSavedState =
            CustomButtonSavedState(parcel)

        override fun newArray(size: Int): Array<CustomButtonSavedState?> =
            arrayOfNulls(size)
    }
}

data class CustomButtonPermanentState(val visibility: Int) : Serializable