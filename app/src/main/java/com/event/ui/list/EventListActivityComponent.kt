package com.event.ui.list

import com.event.di.ApplicationComponent
import dagger.Component

/**
 * Created by Shashank on 28/10/2017.
 */
@Component(modules = arrayOf(EventListActivityModule::class), dependencies = arrayOf(ApplicationComponent::class))
@EventListActivityScope
interface EventListActivityComponent {

    fun injectEventListActivity(activity: EventListActivity)

}