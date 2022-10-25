package com.example.gamecards.data.domain.usescase

import com.example.gamecards.data.domain.model.Card

/**
 * Igor Santos
 * 24/10/2022
 */

interface CardUseCase {
    suspend fun getCardInfos(value: String): List<Card>
}