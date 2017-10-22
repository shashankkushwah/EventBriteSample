package com.event.ui.main

import com.event.data.model.Event
import com.event.ui.base.BaseContract

/**
 * Created by Shashank on 22/10/2017.
 */
interface MainContract {

    interface View : BaseContract.View {
        fun showEvents(events: List<Event>)

        fun showEventDetails(event: Event)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadEvents()

        fun onEventClick(event: Event)
    }

}