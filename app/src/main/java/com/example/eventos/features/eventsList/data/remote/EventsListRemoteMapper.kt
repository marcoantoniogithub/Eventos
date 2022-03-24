package com.example.eventos.features.eventsList.data.remote

import com.example.eventos.features.eventsList.data.remote.model.EventsListResponse
import com.example.eventos.features.eventsList.domain.model.Event

class EventsListRemoteMapper {

    fun map(response: List<EventsListResponse>) = response.map {
        Event(
            people = it.people,
            date = it.date,
            description = it.description,
            image = it.image,
            longitude = it.longitude,
            latitude = it.latitude,
            price = it.price,
            title = it.title,
            id = it.id
        )
    }
}