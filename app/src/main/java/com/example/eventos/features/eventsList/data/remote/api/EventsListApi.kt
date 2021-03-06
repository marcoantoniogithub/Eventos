package com.example.eventos.features.eventsList.data.remote.api

import com.example.eventos.features.eventsList.data.remote.model.EventsListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface EventsListApi {

    @GET("events")
    fun getEvents(): Single<List<EventsListResponse>>

//    fun getEvents() = Single.just(
//        listOf(
//            EventsListResponse(
//                people = null,
//                date = 10L,
//                description = "Descricao",
//                image = "imagem",
//                longitude = 10.0,
//                latitude = 10.0,
//                price = 10.0,
//                title = "titulo",
//                id = "1"
//            ),
//            EventsListResponse(
//                people = null,
//                date = 20L,
//                description = "Descricao",
//                image = "imagem",
//                longitude = 20.0,
//                latitude = 20.0,
//                price = 20.0,
//                title = "titulo",
//                id = "2"
//            )
//        )
//    )
}