package com.event.ui.details

import android.os.Bundle
import com.event.R
import com.event.data.model.Event
import com.event.ui.base.BaseActivity

class EventDetailsActivity : BaseActivity(), EventDetailsContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)
    }

    override fun showEventDetail(event: Event) {

    }

}
