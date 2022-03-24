package com.example.eventos.features.eventsList.data.di

import com.example.eventos.features.eventsList.data.EventsListRepositoryImpl
import com.example.eventos.features.eventsList.data.remote.EventsListRemoteDataSource
import com.example.eventos.features.eventsList.data.remote.EventsListRemoteDataSourceImpl
import com.example.eventos.features.eventsList.data.remote.EventsListRemoteMapper
import com.example.eventos.features.eventsList.data.remote.api.EventsListApi
import com.example.eventos.features.eventsList.domain.repository.EventsListRepository

object EventsListDataFactory {

    fun provideRepository(): EventsListRepository = EventsListRepositoryImpl(
        provideRemoteDataSource()
    )

    private fun provideRemoteDataSource(): EventsListRemoteDataSource =
        EventsListRemoteDataSourceImpl(EventsListApi, EventsListRemoteMapper())
}