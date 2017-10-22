package com.event.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import com.event.EventBriteApplication
import com.event.R
import com.event.data.model.Event
import com.event.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_event_details.*
import ui.sample.data.network.ApiHelper


class EventDetailsActivity : BaseActivity(), EventDetailsContract.View {

    companion object {
        const val EXTRA_EVENT = "event"
    }

    private lateinit var apiHelper: ApiHelper
    private lateinit var picasso: Picasso
    private lateinit var presenter: EventDetailsContract.Presenter
    private lateinit var event: Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)

        val application = EventBriteApplication.get(this)
        apiHelper = application.getApiHelper()
        picasso = application.getPicasso()

        presenter = EventDetailsPresenter(apiHelper)
        presenter.onAttach(this)

        setupViews()
        event = intent.getParcelableExtra<Event>(EXTRA_EVENT)
        presenter.loadEventDetail(event)
    }

    private fun setupViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button_eventbrite.setOnClickListener {
            presenter.onEventUrlClick(event.url)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showEventDetails(event: Event) {
        webview.loadData(event.description.html, "text/html", "UTF-8")
    }

    override fun openEventUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            showMessage(getString(R.string.no_activity_found))
        }
    }

    override fun showProgress() {
        // not needed
    }

    override fun hideProgress() {
        // not needed
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
