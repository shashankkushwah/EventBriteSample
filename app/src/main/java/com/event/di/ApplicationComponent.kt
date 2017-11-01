package com.event.di

import com.event.di.modules.ApiHelperModule
import com.event.di.modules.PicassoModule
import com.squareup.picasso.Picasso
import dagger.Component
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 28/10/2017.
 */

@ApplicationScope
@Component(modules = arrayOf(ApiHelperModule::class, PicassoModule::class))
interface ApplicationComponent {

    fun getApiHelper(): ApiHelper

    fun getPicasso(): Picasso

}