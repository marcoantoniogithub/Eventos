package com.example.eventos

import android.app.Application
import com.example.eventos.core.di.CoreModule
import com.example.eventos.features.eventsList.data.di.EventsListDataFactory
import com.example.eventos.features.eventsList.presentation.di.EventsListPresentationFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    CoreModule.instance,
                    EventsListDataFactory.instance,
                    EventsListPresentationFactory.instance
                )
            )
        }

    }
}