package com.example.eventos.features.eventsList.data.di

import com.example.eventos.features.eventsList.data.EventsListRepositoryImpl
import com.example.eventos.features.eventsList.data.remote.EventsListRemoteDataSource
import com.example.eventos.features.eventsList.data.remote.EventsListRemoteDataSourceImpl
import com.example.eventos.features.eventsList.data.remote.EventsListRemoteMapper
import com.example.eventos.features.eventsList.domain.repository.EventsListRepository
import org.koin.dsl.module

object EventsListDataFactory {

    val instance = module {
        single<EventsListRepository> {
            EventsListRepositoryImpl(
                remoteDataSource = get()
            )
        }

        single<EventsListRemoteDataSource> {
            EventsListRemoteDataSourceImpl(
                eventsListApi = get(),
                mapper = get()
            )
        }

        single<EventsListRemoteMapper> {
            EventsListRemoteMapper()
        }
    }
}