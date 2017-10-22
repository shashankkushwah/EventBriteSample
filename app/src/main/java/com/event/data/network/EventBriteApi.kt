package ui.sample.data.network

import com.event.data.model.EventBriteResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Shashank on 22/10/2017.
 */
interface EventBriteApi {

    @GET("events/search/?token=VBUSKKCQ2VTXKPOP34PX")
    fun getEvents(): Observable<EventBriteResponse>

}