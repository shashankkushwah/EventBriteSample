package com.event.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Shashank on 22/10/2017.
 */
class Event(val name: Name, val description: Description, val id: Long, val url: String, val start: DateTime, val end:
DateTime, val created: String, val changed: String, val capacity: Int, val status: String, val currency: String, val
            listed: Boolean, val shareable: Boolean, @SerializedName("resource_uri") val resourceUri: String, val
            logo: Logo)