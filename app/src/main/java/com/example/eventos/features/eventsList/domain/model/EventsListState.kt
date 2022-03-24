package com.example.eventos.features.eventsList.domain.model

sealed class EventsListState {
    class SuccessLoadEvents(val events: List<Event>) : EventsListState()
    object FailLoadEvents : EventsListState()
}