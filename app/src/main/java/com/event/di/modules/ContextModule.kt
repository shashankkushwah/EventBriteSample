package com.event.di.modules

import android.content.Context
import com.event.di.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Shashank on 28/10/2017.
 */
@Module
class ContextModule(private val context: Context) {

    @Provides
    @ApplicationScope
    fun context(): Context {
        return context
    }

}