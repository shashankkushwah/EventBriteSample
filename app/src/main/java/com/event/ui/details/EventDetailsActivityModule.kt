package com.event.ui.details

import dagger.Module
import dagger.Provides
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 28/10/2017.
 */
@Module
class EventDetailsActivityModule {

    @Provides
    @EventDetailsActivityScope
    fun eventDetailsPresenter(apiHelper: ApiHelper): EventDetailsContract.Presenter {
        return EventDetailsPresenter(apiHelper)
    }

}