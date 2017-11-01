package com.event.di.modules

import com.event.di.ApplicationScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ui.sample.data.network.ApiConfig
import ui.sample.data.network.ApiHelper
import ui.sample.data.network.ApiHelperImpl
import ui.sample.data.network.EventBriteApi

/**
 * Created by Shashank on 28/10/2017.
 */
@Module(includes = arrayOf(NetworkModule::class))
class ApiHelperModule {

    @Provides
    @ApplicationScope
    fun apiHelper(retrofit: Retrofit): ApiHelper {
        return ApiHelperImpl(retrofit.create<EventBriteApi>(EventBriteApi::class.java))
    }

    @Provides
    @ApplicationScope
    fun retrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(ApiConfig.BASE_ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
    }

    @Provides
    @ApplicationScope
    fun gson(): Gson {
        return GsonBuilder().create()
    }

}
