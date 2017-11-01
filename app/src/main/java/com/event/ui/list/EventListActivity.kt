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
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class EventListActivity : BaseActivity(), EventListContract.View, EventListAdapter.EventClickListener {

    @Inject
    lateinit var presenter: EventListContract.Presenter

    @Inject
    lateinit var adapter: EventListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerEventListActivityComponent.builder()
                .eventListActivityModule(EventListActivityModule(this))
                .applicationComponent(EventBriteApplication.get(this).getApplicationComponent())
                .build()
        component.injectEventListActivity(this)

        presenter.onAttach(this)

        setupViews()
        presenter.loadEvents(this)
    }

    private fun setupViews() {
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerview.adapter = adapter

        swiperefreshlayout.setOnRefreshListener {
            presenter.loadEvents(this@EventListActivity)
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
        intent.putExtra(EventDetailsActivity.EXTRA_EVENT_DESCRIPTION, event.description?.html)
        intent.putExtra(EventDetailsActivity.EXTRA_EVENT_URL, event.url)
        startActivity(intent)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
