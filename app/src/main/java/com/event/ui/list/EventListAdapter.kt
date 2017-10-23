package com.event.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.event.R
import com.event.data.model.Event
import com.event.utils.TimeUtils
import com.squareup.picasso.Picasso

/**
 * Created by Shashank on 22/10/2017.
 */
class EventListAdapter(val picasso: Picasso, val eventClickListener: EventClickListener) :
        RecyclerView.Adapter<EventListAdapter.EventViewHolder>() {

    private var events: List<Event> = ArrayList()

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EventViewHolder {
        return EventViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_item_event, parent, false))
    }

    override fun getItemCount(): Int {
        return events.size
    }

    fun setItems(events: List<Event>) {
        this.events = events
        notifyDataSetChanged()
    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                eventClickListener.onEventClick(event!!)
            }
        }

        private var event: Event? = null

        private val thumbnailImageView: ImageView = itemView.findViewById(R.id.imageview_thumbnail)
        private val titleTextView: TextView = itemView.findViewById(R.id.textview_title)
        private val startDateTextView: TextView = itemView.findViewById(R.id.textview_startdate)

        fun bind(event: Event) {
            this.event = event

            if (event.logo?.url != null) {
                picasso.load(event.logo.url).placeholder(R.color.colorLightGray).into(thumbnailImageView);
            } else {
                picasso.load(R.color.colorLightGray).into(thumbnailImageView)
            }

            titleTextView.text = event.name.text
            startDateTextView.text = TimeUtils.parseToEventLocale(event.start)
        }
    }

    interface EventClickListener {
        fun onEventClick(event: Event)
    }
}