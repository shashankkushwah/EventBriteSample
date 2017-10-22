package com.event.data.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Shashank on 22/10/2017.
 */
class AuthRequestInterceptor(private val token: String) : Interceptor {

    companion object {
        private val PARAM_TOKEN = "token"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()
        val url = originalHttpUrl.newBuilder()
                .addQueryParameter(PARAM_TOKEN, token)
                .build()
        val requestBuilder = original.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}