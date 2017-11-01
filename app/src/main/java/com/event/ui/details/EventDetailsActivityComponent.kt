package com.event.ui.details

import com.event.di.ApplicationComponent
import dagger.Component

/**
 * Created by Shashank on 28/10/2017.
 */
@Component(modules = arrayOf(EventDetailsActivityModule::class), dependencies = arrayOf(ApplicationComponent::class))
@EventDetailsActivityScope
interface EventDetailsActivityComponent {

    fun injectEventDetailsActivity(activity: EventDetailsActivity)

}