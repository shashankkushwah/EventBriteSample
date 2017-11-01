package com.event.list

import com.event.data.model.Event
import com.event.ui.list.EventListContract
import com.event.ui.list.EventListPresenter
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import ui.sample.data.network.ApiHelper

/**
 * Created by Shashank on 29/10/2017.
 */
class EventListPresenterTest {

    @Mock
    lateinit var list: List<Event>

    @Mock
    lateinit var apiHelper: ApiHelper

    @Mock
    lateinit var eventListView: EventListContract.View

    private lateinit var eventListPresenter: EventListPresenter

    @Before
    fun setupEventListPresenter() {
        MockitoAnnotations.initMocks(this)

        eventListPresenter = EventListPresenter(apiHelper)
        eventListPresenter.onAttach(eventListView)
    }

}