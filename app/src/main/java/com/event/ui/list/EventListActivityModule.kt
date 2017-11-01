package com.event.ui.list

import dagger.Module
import dagger.Provides
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 28/10/2017.
 */
@Module
class EventListActivityModule(private val activity: EventListActivity) {

    @Provides
    @EventListActivityScope
    fun eventListActivity(): EventListActivity {
        return activity
    }

    @Provides
    @EventListActivityScope
    fun eventListPresenter(apiHelper: ApiHelper): EventListContract.Presenter {
        return EventListPresenter(apiHelper)
    }

}