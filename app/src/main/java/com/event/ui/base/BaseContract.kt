package com.event.ui.base

import android.support.annotation.StringRes

/**
 * Created by Shashank on 22/10/2017.
 */
interface BaseContract {

    interface View {
        fun setProgressIndicator(active: Boolean)

        fun showMessage(message: String)

        fun showMessage(@StringRes resId: Int)

        fun onError(message: String)

        fun onError(@StringRes resId: Int)
    }

    interface Presenter<in V : View> {
        fun onAttach(view: V)

        fun onDetach()
    }

}