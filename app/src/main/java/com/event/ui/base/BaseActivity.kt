package com.event.ui.base

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(), BaseContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setProgressIndicator(active: Boolean) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        showSnackBar(message)
    }

    override fun showMessage(resId: Int) {
        showSnackBar(getString(resId))
    }

    override fun onError(message: String) {
        showSnackBar(message)
    }

    override fun onError(resId: Int) {
        showSnackBar(getString(resId))
    }

    private fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }
}
