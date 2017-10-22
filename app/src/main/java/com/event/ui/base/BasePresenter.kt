package com.event.ui.base

import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 22/10/2017.
 */
abstract class BasePresenter<in V : BaseContract.View>(val apiHelper: ApiHelper) : BaseContract.Presenter<V> {

    private  var view: V? = null

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

}