package com.example.eventos.features.eventsList.data.remote

import com.example.eventos.features.eventsList.domain.model.Event
import io.reactivex.Single

interface EventsListRemoteDataSource {
    fun requestEvents(): Single<List<Event>>
}