package com.event.ui.details

import com.event.R
import com.event.ui.base.BasePresenter
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 22/10/2017.
 */
class EventDetailsPresenter(apiHelper: ApiHelper) : BasePresenter<EventDetailsContract.View>(apiHelper),
        EventDetailsContract.Presenter {

    override fun loadEventDetail(eventDescription: String?) {
        if (eventDescription != null && !eventDescription.isEmpty()) {
            view?.showEventDetails(eventDescription)
        } else {
            view?.onError(R.string.no_event_description)
        }
    }

    override fun onEventUrlClick(url: String?) {
        if (url != null && !url.isEmpty()) {
            view?.openEventUrl(url)
        } else {
            view?.onError(R.string.no_event_url)
        }
    }
}