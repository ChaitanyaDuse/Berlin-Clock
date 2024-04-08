package com.debunrebuild.berlinclock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class BerlinClockViewModel @Inject constructor(val useCase: BerlinClockUseCase) : ViewModel() {
    private val _clockState = MutableLiveData<ClockState>()
    val calendar = Calendar.getInstance()
    val clockState: LiveData<ClockState> = _clockState
    fun setClockEvent(berlinClockEvent: BerlinClockEvent) {
        when (berlinClockEvent) {
            BerlinClockEvent.StartAutomaticClock -> {
                startAutoMaticClock()
            }
        }
    }

    private fun startAutoMaticClock() {
        viewModelScope.launch {
            useCase.startClockUpdates().collect { berlinClock ->
                _clockState.postValue(
                    ClockState(
                        berlinClock.getSeconds(),
                        berlinClock.getTopHourList(),
                        berlinClock.getBottomHourList(),
                        berlinClock.getTopMinuteList(),
                        berlinClock.getBottomMinuteList(),
                        berlinClock.getClockText()
                    )
                )
            }
        }
    }

}


data class ClockState(
    val seconds: LampState,
    val topHour: Array<LampState>,
    val bottomHour: Array<LampState>,
    val topMinutes: Array<LampState>,
    val bottomMinutes: Array<LampState>,
    val clockText: String
)

sealed class BerlinClockEvent {
    data object StartAutomaticClock : BerlinClockEvent()
}