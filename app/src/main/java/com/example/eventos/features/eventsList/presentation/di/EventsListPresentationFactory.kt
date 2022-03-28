package com.example.eventos.features.eventsList.presentation.di

import com.example.eventos.features.eventsList.domain.usecase.EventsListUseCase
import com.example.eventos.features.eventsList.domain.usecase.EventsListUseCaseImpl
import com.example.eventos.features.eventsList.presentation.EventsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object EventsListPresentationFactory {

    val instance = module {
        viewModel {
            EventsListViewModel(
                useCase = get()
            )
        }

        factory<EventsListUseCase> {
            EventsListUseCaseImpl(
                repository = get()
            )
        }
    }
}