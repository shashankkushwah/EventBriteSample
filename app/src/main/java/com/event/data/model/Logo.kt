package com.event.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Shashank on 22/10/2017.
 */
class Logo(val original: Image, val id: Long, val url: String?) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readLong(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(original, 0)
        writeLong(id)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Logo> = object : Parcelable.Creator<Logo> {
            override fun createFromParcel(source: Parcel): Logo = Logo(source)
            override fun newArray(size: Int): Array<Logo?> = arrayOfNulls(size)
        }
    }
}