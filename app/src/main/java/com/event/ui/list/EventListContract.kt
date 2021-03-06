package com.event.ui.list

import android.content.Context
import com.event.data.model.Event
import com.event.ui.base.BaseContract

/**
 * Created by Shashank on 22/10/2017.
 */
interface EventListContract {

    interface View : BaseContract.View {
        fun showEvents(events: List<Event>)

        fun showEventDetails(event: Event)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadEvents(context: Context)

        fun onEventClick(event: Event)
    }

}