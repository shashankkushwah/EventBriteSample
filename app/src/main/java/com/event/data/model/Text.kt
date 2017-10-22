package com.event.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Shashank on 22/10/2017.
 */
class Text(val text: String, val html: String) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(text)
        writeString(html)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Text> = object : Parcelable.Creator<Text> {
            override fun createFromParcel(source: Parcel): Text = Text(source)
            override fun newArray(size: Int): Array<Text?> = arrayOfNulls(size)
        }
    }
}