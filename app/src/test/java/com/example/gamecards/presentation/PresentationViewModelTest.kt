package com.example.gamecards.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.gamecards.data.domain.model.Card
import com.example.gamecards.data.domain.repository.CardRepository
import com.example.gamecards.data.domain.usescase.CardUseCase
import com.example.gamecards.view.cardselected.CardSelectedViewModel
import com.example.gamecards.view.factionhorde.FactionHordeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Igor Santos
 * 25/10/2022
 */

@ExperimentalCoroutinesApi
class PresentationViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var useCase: CardUseCase
    private lateinit var repository: CardRepository
    private lateinit var cardSelectedViewModel: CardSelectedViewModel
    private lateinit var factionHordeViewModel: FactionHordeViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun before() {
        useCase = mockk(relaxed = true)
        repository = mockk(relaxed = true)
        cardSelectedViewModel = CardSelectedViewModel(useCase)
        factionHordeViewModel = FactionHordeViewModel(repository)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `test if card geral data is written`() {
        val card = mockk<List<Card>>()
        coEvery { repository.getHorde() } returns card
        factionHordeViewModel.getHorde()
        assertEquals(card, factionHordeViewModel.factionHorde.value)
    }

    @Test
    fun `test if card details data is written`() {
        val card = mockk<List<Card>>()
        val cardId = "EX1_572"
        coEvery { useCase.getCardInfos(cardId) } returns card
        cardSelectedViewModel.getSelectedCard(cardId)
        assertEquals(card, cardSelectedViewModel.cardInfos.value)
    }
}