package com.example.eventos.features.eventsList.data.remote

import com.example.eventos.features.eventsList.data.remote.api.EventsListApi
import com.example.eventos.features.eventsList.domain.model.Event
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EventsListRemoteDataSourceImpl(
    private val eventsListApi: EventsListApi,
    private val mapper: EventsListRemoteMapper
) : EventsListRemoteDataSource {


    override fun requestEvents(): Single<List<Event>> =
        eventsListApi.getEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map(mapper::map)
}