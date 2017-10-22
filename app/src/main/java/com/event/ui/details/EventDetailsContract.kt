package com.event.ui.details

import com.event.data.model.Event
import com.event.ui.base.BaseContract

/**
 * Created by Shashank on 22/10/2017.
 */
interface EventDetailsContract {

    interface View : BaseContract.View {
        fun showEventDetail(event: Event)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadEventDetail(event: Event)

        fun onEventUrlClick(url: String)
    }

}