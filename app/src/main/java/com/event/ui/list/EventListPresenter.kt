package com.event.ui.list

import android.content.Context
import com.event.R
import com.event.data.model.Event
import com.event.ui.base.BasePresenter
import com.event.utils.NetworkUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 22/10/2017.
 */
class EventListPresenter(apiHelper: ApiHelper) : BasePresenter<EventListContract.View>(apiHelper),
        EventListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadEvents(context: Context) {
        view?.showProgress()
        if (NetworkUtils.isNetworkConnected(context)) {
            compositeDisposable.add(apiHelper.getEvents().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                    .mainThread()).subscribe({ comicResponse ->
                view?.hideProgress()
                view?.showEvents(comicResponse.events)
            }, { t: Throwable ->
                var message = "Something went wrong!"
                t.message?.let {
                    message = t.message!!
                }
                view?.hideProgress()
                view?.onError(message)
            }))
        } else {
            view?.hideProgress()
            view?.onError(R.string.no_internet_connection)
        }
    }

    override fun onEventClick(event: Event) {
        view?.showEventDetails(event)
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        super.onDetach()
    }
}