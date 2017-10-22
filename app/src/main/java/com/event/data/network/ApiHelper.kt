package ui.sample.data.network

import com.event.data.model.Event

/**
 * Created by Shashank on 22/10/2017.
 */
interface ApiHelper {

    interface Callback<T> {

        fun onSuccess(data: T)

        fun onFailed(message: String)
    }

    fun getEvents(callback: Callback<List<Event>>)

}