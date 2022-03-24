package com.example.eventos.features.eventsList.domain.usecase

import com.example.eventos.features.eventsList.domain.model.Event
import com.example.eventos.features.eventsList.domain.model.EventsListState
import com.example.eventos.features.eventsList.domain.repository.EventsListRepository
import io.reactivex.Single

class EventsListUseCaseImpl(private val repository: EventsListRepository) : EventsListUseCase {

    override fun loadEvents(): Single<EventsListState> =
        repository.requestEvents().map { mapEventToState(it) }

    private fun mapEventToState(list: List<Event>?) =
        when {
            list.isNullOrEmpty() -> EventsListState.FailLoadEvents
            else -> EventsListState.SuccessLoadEvents(list)
        }
}