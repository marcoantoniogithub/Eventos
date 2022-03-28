package com.example.eventos.core.di

import com.example.eventos.core.network.AuthInterceptor
import com.example.eventos.core.network.NetworkConfig
import com.example.eventos.features.eventsList.data.remote.api.EventsListApi
import org.koin.dsl.module
import retrofit2.Retrofit

object CoreModule {
    val instance = module {
        factory { AuthInterceptor() }
        factory { NetworkConfig.provideOkHttpClient(get()) }
        single<Retrofit> { NetworkConfig.provideRetrofit(get()) }
        single<EventsListApi> { NetworkConfig.provideEventsApi(get())}

    }
}