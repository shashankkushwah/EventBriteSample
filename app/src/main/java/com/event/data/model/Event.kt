package com.event.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Shashank on 22/10/2017.
 */
class Event(val name: Text, val description: Text, val id: Long, val url: String, val start: DateTime, val end:
DateTime, val created: String, val changed: String, val capacity: Int, val status: String, val currency: String, val
            listed: Boolean, val shareable: Boolean, @SerializedName("resource_uri") val resourceUri: String, val
            logo: Logo) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<Text>(Text::class.java.classLoader),
            source.readParcelable<Text>(Text::class.java.classLoader),
            source.readLong(),
            source.readString(),
            source.readParcelable<DateTime>(DateTime::class.java.classLoader),
            source.readParcelable<DateTime>(DateTime::class.java.classLoader),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readString(),
            source.readString(),
            1 == source.readInt(),
            1 == source.readInt(),
            source.readString(),
            source.readParcelable<Logo>(Logo::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(name, 0)
        writeParcelable(description, 0)
        writeLong(id)
        writeString(url)
        writeParcelable(start, 0)
        writeParcelable(end, 0)
        writeString(created)
        writeString(changed)
        writeInt(capacity)
        writeString(status)
        writeString(currency)
        writeInt((if (listed) 1 else 0))
        writeInt((if (shareable) 1 else 0))
        writeString(resourceUri)
        writeParcelable(logo, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Event> = object : Parcelable.Creator<Event> {
            override fun createFromParcel(source: Parcel): Event = Event(source)
            override fun newArray(size: Int): Array<Event?> = arrayOfNulls(size)
        }
    }
}