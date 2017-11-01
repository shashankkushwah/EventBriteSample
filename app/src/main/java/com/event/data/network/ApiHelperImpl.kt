package ui.sample.data.network

import com.event.data.model.EventBriteResponse
import io.reactivex.Observable

/**
 * Created by Shashank on 22/10/2017.
 */
class ApiHelperImpl(private val api: EventBriteApi) : ApiHelper {

    override fun getEvents(): Observable<EventBriteResponse> {
        return api.getEvents()
    }
}