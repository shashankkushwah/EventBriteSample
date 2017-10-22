package com.event.ui.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.event.EventBriteApplication
import com.event.R
import com.event.data.model.Event
import com.event.ui.base.BaseActivity
import com.event.ui.details.EventDetailsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import ui.sample.data.network.ApiHelper

class EventListActivity : BaseActivity(), EventListContract.View, EventListAdapter.EventClickListener {


    private lateinit var apiHelper: ApiHelper
    private lateinit var picasso: Picasso
    private lateinit var presenter: EventListContract.Presenter
    private lateinit var adapter: EventListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val application = EventBriteApplication.get(this)
        apiHelper = application.getApiHelper()
        picasso = application.getPicasso()
        presenter = EventListPresenter(apiHelper)
        presenter.onAttach(this)

        setupViews()
        presenter.loadEvents(this)
    }

    private fun setupViews() {
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter = EventListAdapter(picasso, this)
        recyclerview.adapter = adapter

        swiperefreshlayout.setOnRefreshListener {
            swiperefreshlayout.isRefreshing = false
//                presenter.loadEvents()
        }
    }

    override fun onEventClick(event: Event) {
        presenter.onEventClick(event)
    }

    override fun showProgress() {
        swiperefreshlayout.post({ swiperefreshlayout.isRefreshing = true })
    }

    override fun hideProgress() {
        swiperefreshlayout.post({ swiperefreshlayout.isRefreshing = false })
    }

    override fun showEvents(events: List<Event>) {
        adapter.setItems(events)
    }

    override fun showEventDetails(event: Event) {
        val intent = Intent(this, EventDetailsActivity::class.java)
        intent.putExtra(EventDetailsActivity.EXTRA_EVENT, event)
        startActivity(intent)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
