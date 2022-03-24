package com.example.eventos.features.eventsList.data

import com.example.eventos.features.eventsList.data.remote.EventsListRemoteDataSource
import com.example.eventos.features.eventsList.domain.model.Event
import com.example.eventos.features.eventsList.domain.repository.EventsListRepository
import io.reactivex.Single

class EventsListRepositoryImpl(
    val remoteDataSource: EventsListRemoteDataSource
) : EventsListRepository {

    override fun requestEvents(): Single<List<Event>> =
        remoteDataSource.requestEvents()
}