package com.event.di.modules

import android.content.Context
import com.event.di.ApplicationScope
import com.jakewharton.picasso.OkHttp3Downloader
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Shashank on 28/10/2017.
 */
@Module(includes = arrayOf(ContextModule::class))
class NetworkModule {

    @Provides
    @ApplicationScope
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient().newBuilder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .followSslRedirects(true)
                .addInterceptor(loggingInterceptor)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .connectionPool(ConnectionPool(30, 120, TimeUnit.SECONDS))
                .cache(cache).build()
    }

    @Provides
    @ApplicationScope
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @ApplicationScope
    fun okHttp3Downloader(okHttpClient: OkHttpClient): OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }

    @Provides
    @ApplicationScope
    fun cache(cacheFile: File): Cache {
        return Cache(cacheFile, 50 * 1000 * 1000)
    }

    @Provides
    @ApplicationScope
    fun cacheFile(context: Context): File {
        val cacheFile = File(context.cacheDir, "okttp_cache")
        cacheFile.mkdirs()
        return cacheFile;
    }

}