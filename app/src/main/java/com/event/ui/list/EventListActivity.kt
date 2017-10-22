package com.event.ui.list

import android.os.Bundle
import com.event.R
import com.event.data.model.Event
import com.event.ui.base.BaseActivity

class EventListActivity : BaseActivity(), EventListContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun showEvents(events: List<Event>) {

    }

    override fun showEventDetails(event: Event) {

    }
}
