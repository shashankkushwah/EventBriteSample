package com.event.ui.list

import com.event.data.model.Event
import com.event.ui.base.BasePresenter
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 22/10/2017.
 */
class EventListPresenter(apiHelper: ApiHelper) : BasePresenter<EventListContract.View>(apiHelper), EventListContract.Presenter {

    override fun loadEvents() {

    }

    override fun onEventClick(event: Event) {

    }

}