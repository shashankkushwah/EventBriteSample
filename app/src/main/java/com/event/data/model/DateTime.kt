package com.event.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Shashank on 22/10/2017.
 */
class DateTime(val timezone: String?, val local: String, val utc: String) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(timezone)
        writeString(local)
        writeString(utc)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<DateTime> = object : Parcelable.Creator<DateTime> {
            override fun createFromParcel(source: Parcel): DateTime = DateTime(source)
            override fun newArray(size: Int): Array<DateTime?> = arrayOfNulls(size)
        }
    }
}