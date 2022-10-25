package com.example.gamecards.data.domain.repository

import com.example.gamecards.data.domain.network.CardService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Igor Santos
 * 24/10/2022
 */

@Singleton
class CardRepositoryImpl @Inject constructor(
    private val service: CardService
) : CardRepository{
    override suspend fun getCard(cardId: String) = service.getSelectedCards(cardId)
    override suspend fun getHorde() = service.getFactionHorde()
}