package com.event.utils

import android.content.Context
import android.net.ConnectivityManager


/**
 * Created by Shashank on 22/10/2017.
 */
class NetworkUtils {

    companion object {
        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
    }
}