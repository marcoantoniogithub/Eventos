package com.example.eventos.features.eventsList.presentation.di

import com.example.eventos.features.eventsList.data.di.EventsListDataFactory
import com.example.eventos.features.eventsList.domain.usecase.EventsListUseCaseImpl
import com.example.eventos.features.eventsList.presentation.EventsListViewModel

object EventsListPresentationFactory {

    fun provideListEventsViewModel(): EventsListViewModel = EventsListViewModel(
        provideUseCase()
    )

    private fun provideUseCase() = EventsListUseCaseImpl(EventsListDataFactory.provideRepository())
}