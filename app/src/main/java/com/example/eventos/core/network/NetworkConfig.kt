package com.example.eventos.core.network

import com.example.eventos.BuildConfig
import com.example.eventos.features.eventsList.data.remote.api.EventsListApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
    }

    fun provideEventsApi(retrofit: Retrofit): EventsListApi = retrofit.create(EventsListApi::class.java)
}