package com.vallente.animal.midterm.dataModels

import android.os.Parcel
import android.os.Parcelable

data class AnimalData(val animalName: String, val animalDescription: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(animalName)
        parcel.writeString(animalDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AnimalData> {
        override fun createFromParcel(parcel: Parcel): AnimalData {
            return AnimalData(parcel)
        }

        override fun newArray(size: Int): Array<AnimalData?> {
            return arrayOfNulls(size)
        }
    }
}

