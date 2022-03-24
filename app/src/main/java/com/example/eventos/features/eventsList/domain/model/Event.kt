package com.example.eventos.features.eventsList.domain.model

import com.google.gson.annotations.SerializedName

data class Event(
    val people: List<Any>?,
    val date: Long,
    val description: String,
    val image: String,
    val longitude: Double,
    val latitude: Double,
    val price: Double,
    val title: String,
    val id: String,
)