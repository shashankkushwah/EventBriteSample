package com.event.ui.details

import com.event.data.model.Event
import com.event.ui.base.BasePresenter
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 22/10/2017.
 */
class EventDetailsPresenter(apiHelper: ApiHelper) : BasePresenter<EventDetailsContract.View>(apiHelper),
        EventDetailsContract.Presenter {

    override fun loadEventDetail(event: Event) {
    }

    override fun onEventUrlClick(url: String) {
    }
}