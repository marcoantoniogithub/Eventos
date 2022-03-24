package com.example.eventos.features.eventsList.domain.usecase

import com.example.eventos.features.eventsList.domain.model.EventsListState
import io.reactivex.Single

interface EventsListUseCase {
    fun loadEvents(): Single<EventsListState>
}