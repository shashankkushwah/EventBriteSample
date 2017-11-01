package com.event.di.modules

import android.content.Context
import com.event.di.ApplicationScope
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

/**
 * Created by Shashank on 28/10/2017.
 */
@Module(includes = arrayOf(ContextModule::class, NetworkModule::class))
class PicassoModule {

    @Provides
    @ApplicationScope
    fun picasso(context: Context, okHttp3Downloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context).downloader(okHttp3Downloader).build()
    }

}