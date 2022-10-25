package com.example.gamecards.data.domain.network

import com.example.gamecards.data.domain.model.Card
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Igor Santos
 * 24/10/2022
 */

interface CardService {

    @GET("cards/{cardId}")
    suspend fun getSelectedCards(@Path("cardId")cardId: String): List<Card>

    @GET("cards/factions/Horde")
    suspend fun getFactionHorde(): List<Card>
}