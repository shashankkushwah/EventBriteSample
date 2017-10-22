package com.event.ui.details

import com.event.data.model.Event
import com.event.ui.base.BaseContract

/**
 * Created by Shashank on 22/10/2017.
 */
interface EventDetailsContract {

    interface View : BaseContract.View {
        fun showEventDetails(event: Event)
        fun openEventUrl(url: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadEventDetail(event: Event)

        fun onEventUrlClick(url: String)
    }

}