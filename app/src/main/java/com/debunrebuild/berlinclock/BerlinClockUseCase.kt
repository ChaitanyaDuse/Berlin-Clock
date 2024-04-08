package com.debunrebuild.berlinclock

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf


class BerlinClockUseCase {

    fun startClockUpdates(): Flow<BerlinClock> = flow {
        while (true) {
        val berlinClock = BerlinClock(System.currentTimeMillis())
        emit(berlinClock)
        delay(1000)
        }
    }


}