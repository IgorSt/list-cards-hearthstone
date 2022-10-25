package com.example.gamecards.data.domain.usescase.di

import com.example.gamecards.data.domain.usescase.CardUseCase
import com.example.gamecards.data.domain.usescase.CardUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Igor Santos
 * 24/10/2022
 */

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Singleton
    @Binds
    fun bindUseCase(useCaseImpl: CardUseCaseImpl): CardUseCase
}