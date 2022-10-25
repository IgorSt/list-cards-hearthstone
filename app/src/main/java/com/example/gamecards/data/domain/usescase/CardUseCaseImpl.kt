package com.example.gamecards.data.domain.usescase

import com.example.gamecards.data.domain.repository.CardRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Igor Santos
 * 24/10/2022
 */

@Singleton
class CardUseCaseImpl @Inject constructor(
    private val repository: CardRepository
) : CardUseCase {
    override suspend fun getCardInfos(cardId: String) = repository.getCard(cardId)
}