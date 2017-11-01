package com.event

import android.app.Activity
import android.app.Application
import com.event.di.ApplicationComponent
import com.event.di.DaggerApplicationComponent
import com.event.di.modules.ContextModule

/**
 * Created by Shashank on 22/10/2017.
 */
class EventBriteApplication : Application() {

    companion object {
        fun get(activity: Activity): EventBriteApplication {
            return activity.applicationContext as EventBriteApplication
        }
    }

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }
}