package com.example.eventos.features.eventsList.domain.repository

import com.example.eventos.features.eventsList.domain.model.Event
import io.reactivex.Single

interface EventsListRepository {
    fun requestEvents(): Single<List<Event>>
}