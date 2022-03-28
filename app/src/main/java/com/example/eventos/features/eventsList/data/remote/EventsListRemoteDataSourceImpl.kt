package com.example.eventos.features.eventsList.data.remote

import com.example.eventos.BuildConfig
import com.example.eventos.features.eventsList.data.remote.api.EventsListApi
import com.example.eventos.features.eventsList.domain.model.Event
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventsListRemoteDataSourceImpl(
    private val eventsListApi: EventsListApi,
    private val mapper: EventsListRemoteMapper
) : EventsListRemoteDataSource {


    override fun requestEvents(): Single<List<Event>> =

//        val retrofit = Retrofit.Builder().baseUrl(BuildConfig.API_URL)
//            .addConverterFactory(GsonConverterFactory.create()).build().create(EventsListApi::class.java)

//        var resposta = eventsListApi.getEvents().map(mapper::map)
//
//        return  resposta
//    }
        eventsListApi.getEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                println(it.message)
            }
            .map(mapper::map)


//        Single.just(
//            listOf(
//                Event(
//                    people = null,
//                    date = 10L,
//                    description = "Descricao",
//                    image = "imagem",
//                    longitude = 10.0,
//                    latitude = 10.0,
//                    price = 10.0,
//                    title = "titulo",
//                    id = "1"
//                )
//            )
//        )

}