package com.event.utils

import com.event.data.model.DateTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Shashank on 22/10/2017.
 */
class TimeUtils {
    companion object {
        private val jsonDateTimeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        private val displayDateTimeFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

        fun parseRawDateTime(dateTime: DateTime): String? {
            var date: String? = null
            try {
                val cal: Calendar
                if (dateTime.timezone != null) {
                    val timeZone = TimeZone.getTimeZone(dateTime.timezone)
                    cal = Calendar.getInstance(TimeZone.getDefault())
                    jsonDateTimeFormat.timeZone = timeZone
                    cal.time = jsonDateTimeFormat.parse(dateTime.local)
                } else {
                    cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                    cal.time = jsonDateTimeFormat.parse(dateTime.utc)
                }
                date = displayDateTimeFormat.format(cal.time)
            } catch (ex: ParseException) {
                ex.printStackTrace()
            }
            return date
        }
    }

}