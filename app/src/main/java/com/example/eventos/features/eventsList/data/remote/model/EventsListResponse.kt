package com.example.eventos.features.eventsList.data.remote.model

import com.google.gson.annotations.SerializedName

data class EventsListResponse(
    @SerializedName("people") val people: List<Any>?,
    @SerializedName("date") val date: Long,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("price") val price: Double,
    @SerializedName("title") val title: String,
    @SerializedName("id") val id: String,
)