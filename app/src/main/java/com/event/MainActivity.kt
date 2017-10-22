package com.event

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.event.data.model.Event
import ui.sample.data.network.ApiHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        EventBriteApplication.get(this).getApiHelper().getEvents(object : ApiHelper.Callback<List<Event>> {
            override fun onSuccess(data: List<Event>) {
                Log.i("ApiTest", "List size: " + data.size)
            }

            override fun onFailed(message: String) {
                Log.i("ApiTest", "Api call failed: " + message)
            }

        })
    }
}
