package com.debunrebuild.berlinclock.di

import com.debunrebuild.berlinclock.BerlinClockUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClockModule {

    @Provides
    @Singleton
    fun provideUseCase() = BerlinClockUseCase()
}