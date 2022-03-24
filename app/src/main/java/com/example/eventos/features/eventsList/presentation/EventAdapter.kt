package com.example.eventos.features.eventsList.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventos.features.eventsList.domain.model.Event
import com.example.eventos.R
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso

class EventAdapter(
    private val listener: (Event) -> Unit
) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private val events: MutableList<Event> = mutableListOf()

    fun clearAndAdd(event: List<Event>) {
        events.clear()
        events.addAll(event)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list, viewGroup, false)
        )
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val eventModel = events[position]
        viewHolder.binding(eventModel) { listener(eventModel) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.card_title)
        private val price: TextView = view.findViewById(R.id.card_price)
        private val img: ImageView = view.findViewById(R.id.card_img)
        private val card: MaterialCardView = view.findViewById(R.id.card)
        private var id: String = "0"

        fun binding(eventItem: Event, onItemClickListener: () -> Unit) {
            title.text =
                if (eventItem.title.length < 13) eventItem.title else eventItem.title.substring(
                    0,
                    10
                ) + "..."
            price.text = eventItem.price.toString()
            Picasso.get()
                .load(eventItem.image)
                .error(R.drawable.ic_baseline_image_not_supported_24)
                .into(img)
            id = eventItem.id
            card.setOnClickListener {
                onItemClickListener.invoke()
            }
        }
    }
}

