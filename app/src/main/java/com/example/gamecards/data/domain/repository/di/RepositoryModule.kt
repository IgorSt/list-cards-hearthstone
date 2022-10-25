package com.example.gamecards.data.domain.repository.di

import com.example.gamecards.data.domain.repository.CardRepository
import com.example.gamecards.data.domain.repository.CardRepositoryImpl
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
interface RepositoryModule {
    @Singleton
    @Binds
    fun bindRepository(repositoryImpl: CardRepositoryImpl): CardRepository
}