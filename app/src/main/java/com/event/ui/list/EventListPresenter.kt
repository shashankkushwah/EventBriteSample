package com.event.ui.list

import android.content.Context
import com.event.R
import com.event.data.model.Event
import com.event.ui.base.BasePresenter
import com.event.utils.NetworkUtils
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 22/10/2017.
 */
class EventListPresenter(apiHelper: ApiHelper) : BasePresenter<EventListContract.View>(apiHelper), EventListContract.Presenter {

    override fun loadEvents(context: Context) {
        view?.showProgress()
        if (NetworkUtils.isNetworkConnected(context)) {
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
        } else {
            view?.hideProgress()
            view?.onError(R.string.no_internet_connection)
        }
    }

    override fun onEventClick(event: Event) {
        view?.showEventDetails(event)
    }

}