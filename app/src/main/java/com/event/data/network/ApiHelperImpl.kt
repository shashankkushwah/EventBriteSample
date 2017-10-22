package ui.sample.data.network

import com.event.data.model.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Shashank on 22/10/2017.
 */
class ApiHelperImpl(private val api: EventBriteApi) : ApiHelper {

    override fun getEvents(callback: ApiHelper.Callback<List<Event>>) {
        api.getEvents().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ comicResponse ->
            callback.onSuccess(comicResponse.events)
        }, { t: Throwable ->
            var message = "Something went wrong!"
            t.message?.let {
                message = t.message!!
            }
            callback.onFailed(message)
        })
    }
}