package com.event.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import com.event.EventBriteApplication
import com.event.R
import com.event.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_event_details.*
import ui.sample.data.network.ApiHelper


class EventDetailsActivity : BaseActivity(), EventDetailsContract.View {

    companion object {
        const val EXTRA_EVENT_DESCRIPTION = "event_description"
        const val EXTRA_EVENT_URL = "event_url"
    }

    private lateinit var apiHelper: ApiHelper
    private lateinit var picasso: Picasso
    private lateinit var presenter: EventDetailsContract.Presenter
    private var eventDescription: String? = null
    private var eventUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)

        val application = EventBriteApplication.get(this)
        apiHelper = application.getApiHelper()
        picasso = application.getPicasso()

        presenter = EventDetailsPresenter(apiHelper)
        presenter.onAttach(this)

        setupViews()
        eventDescription = intent.getStringExtra(EXTRA_EVENT_DESCRIPTION)
        eventUrl = intent.getStringExtra(EXTRA_EVENT_URL)
        presenter.loadEventDetail(eventDescription)
    }

    private fun setupViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button_eventbrite.setOnClickListener {
            presenter.onEventUrlClick(eventUrl)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showEventDetails(eventDescription: String) {
        webview.loadData(eventDescription, "text/html", "UTF-8")
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
