package ui.sample.data.network

import com.event.data.model.EventBriteResponse
import io.reactivex.Observable

/**
 * Created by Shashank on 22/10/2017.
 */
interface ApiHelper {

    fun getEvents(): Observable<EventBriteResponse>

}