package com.event.details

import com.event.R
import com.event.ui.details.EventDetailsContract
import com.event.ui.details.EventDetailsPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 29/10/2017.
 */
class EventDetailsPresenterTest {

    @Mock
    lateinit var apiHelper: ApiHelper

    @Mock
    lateinit var eventDetailsView: EventDetailsContract.View

    private lateinit var eventDetailsPresenter: EventDetailsPresenter

    @Before
    fun setupEventListPresenter() {
        MockitoAnnotations.initMocks(this)

        eventDetailsPresenter = EventDetailsPresenter(apiHelper)
        eventDetailsPresenter.onAttach(eventDetailsView)
    }

    @Test
    fun loadEventDetailsAndLoadIntoView() {
        val description = "some mock description"
        eventDetailsPresenter.loadEventDetail(description)
        Mockito.verify(eventDetailsView).showEventDetails(description)
    }

    @Test
    fun loadEventDetailsAndFail() {
        eventDetailsPresenter.loadEventDetail(null)
        Mockito.verify(eventDetailsView).onError(R.string.no_event_description)
    }

    @Test
    fun clickOnEventUrl_OpenEventUrl() {
        val url = "some mock url"
        eventDetailsPresenter.onEventUrlClick(url)
        Mockito.verify(eventDetailsView).openEventUrl(url)
    }

    @Test
    fun clickOnEventUrl_AndFail() {
        eventDetailsPresenter.onEventUrlClick(null)
        Mockito.verify(eventDetailsView).onError(R.string.no_event_url)
    }

}