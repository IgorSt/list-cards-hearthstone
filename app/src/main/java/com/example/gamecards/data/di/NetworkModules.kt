package com.example.gamecards.data.di

import com.example.gamecards.data.domain.network.CardService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Igor Santos
 * 24/10/2022
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModules {

    private const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com/"
    private const val BASE_KEY = "96ed3a41e4msh4c6a05499a263ecp12a7d3jsn91e4b320bdf7"
    private const val BASE_HOST = "omgvamp-hearthstone-v1.p.rapidapi.com"

    val apiInterceptor = Interceptor {
        val originRequest = it.request()
        val newHttpUrl = originRequest.newBuilder()
            .header("X-RapidAPI-Key", BASE_KEY)
            .header("X-RapidAPI-Host", BASE_HOST)
            .build()
        it.proceed(newHttpUrl)
    }

    val clientHTTP = OkHttpClient().newBuilder()
        .addInterceptor(apiInterceptor)
        .build()

    @Singleton
    @Provides
    fun cardService(gson: Gson): CardService {
        return Retrofit.Builder()
            .client(clientHTTP)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CardService::class.java)
    }
}