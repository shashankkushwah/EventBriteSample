package com.event.ui.list

import com.event.data.model.Event
import com.event.ui.base.BasePresenter
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 22/10/2017.
 */
class EventListPresenter(apiHelper: ApiHelper) : BasePresenter<EventListContract.View>(apiHelper), EventListContract.Presenter {

    override fun loadEvents() {
        view?.showProgress()
        apiHelper.getEvents(object : ApiHelper.Callback<List<Event>> {

            override fun onSuccess(data: List<Event>) {
                view?.hideProgress()
                view?.showEvents(data)
            }

            override fun onFailed(message: String) {
                view?.hideProgress()
                view?.onError(message)
            }
        })
    }

    override fun onEventClick(event: Event) {

    }

}