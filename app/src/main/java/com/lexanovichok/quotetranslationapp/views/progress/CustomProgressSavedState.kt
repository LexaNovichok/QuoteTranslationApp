package com.lexanovichok.quotetranslationapp.views.progress

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import java.io.Serializable

class CustomProgressSavedState : View.BaseSavedState {

    private lateinit var state : CustomProgressPermanentState

    constructor(superState : Parcelable) : super(superState)

    private constructor(parcelIn : Parcel) : super(parcelIn) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            state = parcelIn.readSerializable(CustomProgressPermanentState::class.java.classLoader, CustomProgressPermanentState::class.java)!!
        } else {
            parcelIn.readSerializable() as CustomProgressPermanentState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore() : CustomProgressPermanentState = state

    fun save(uiState : CustomProgressPermanentState) {
        state = uiState
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CustomProgressSavedState> {
        override fun createFromParcel(parcel: Parcel): CustomProgressSavedState =
            CustomProgressSavedState(parcel)

        override fun newArray(size: Int): Array<CustomProgressSavedState?> =
            arrayOfNulls(size)
    }
}

data class CustomProgressPermanentState(val visibility: Int) : Serializable