package com.event

import android.app.Activity
import android.app.Application
import com.google.gson.GsonBuilder
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ui.sample.data.network.ApiConfig
import ui.sample.data.network.ApiHelper
import ui.sample.data.network.ApiHelperImpl
import ui.sample.data.network.EventBriteApi
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Shashank on 22/10/2017.
 */
class EventBriteApplication : Application() {

    companion object {
        fun get(activity: Activity): EventBriteApplication {
            return activity.applicationContext as EventBriteApplication
        }
    }

    private lateinit var apiHelper: ApiHelper
    private lateinit var picasso: Picasso

    override fun onCreate() {
        super.onCreate()

        val gson = GsonBuilder().create()

        val cacheFile = File(cacheDir, "okttp_cache")
        cacheFile.mkdirs()
        val cache = Cache(cacheFile, 50 * 1000 * 1000)

        val httpClientBuilder = OkHttpClient().newBuilder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(loggingInterceptor)
        }

        val okHttpClient = httpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .followSslRedirects(true)
                .followRedirects(true).retryOnConnectionFailure(true)
                .connectionPool(ConnectionPool(30, 120, TimeUnit.SECONDS))
                .cache(cache).build()

        val retrofit = Retrofit.Builder()
                .baseUrl(ApiConfig.BASE_ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()

        apiHelper = ApiHelperImpl(retrofit.create<EventBriteApi>(EventBriteApi::class.java))
        picasso = Picasso.Builder(applicationContext).downloader(OkHttp3Downloader(okHttpClient)).build()

    }

    fun getApiHelper(): ApiHelper {
        return apiHelper
    }

    fun getPicasso(): Picasso {
        return picasso
    }
}