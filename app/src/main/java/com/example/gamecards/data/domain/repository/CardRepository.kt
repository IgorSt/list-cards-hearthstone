package com.example.gamecards.data.domain.repository

import com.example.gamecards.data.domain.model.Card

/**
 * Igor Santos
 * 24/10/2022
 */

interface CardRepository {
    suspend fun getCard(cardId: String): List<Card>
    suspend fun getHorde(): List<Card>
}