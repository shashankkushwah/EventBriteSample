package com.event.ui.details

import com.event.ui.base.BaseContract

/**
 * Created by Shashank on 22/10/2017.
 */
interface EventDetailsContract {

    interface View : BaseContract.View {
        fun showEventDetails(description: String)
        fun openEventUrl(url: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadEventDetail(description: String?)

        fun onEventUrlClick(url: String?)
    }

}