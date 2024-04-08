package com.debunrebuild.berlinclock

class BerlinClock(currentTimeMillis: Long) {
    private var seconds: LampState
    private var topHour: Array<LampState>

    private var bottomHour: Array<LampState>
    private var topMinutes: Array<LampState>
    private var bottomMinutes: Array<LampState>
    private val standardTime: StandardClock = StandardClock()

    init {
        standardTime.setTime(currentTimeMillis)
        seconds = getSecondsState(standardTime.second)
        topHour = getTopHourList(standardTime.hour)
        bottomHour = getBottomHourList(standardTime.hour)
        topMinutes = getTopMinuteList(standardTime.minute)
        bottomMinutes = getBottomMinuteList(standardTime.minute)
    }

    fun getSeconds() = seconds
    fun getTopHourList(): Array<LampState> {
        return topHour
    }

    fun getBottomHourList(): Array<LampState> {
        return bottomHour
    }

    fun getTopMinuteList(): Array<LampState> {
        return topMinutes
    }

    fun getBottomMinuteList(): Array<LampState> {
        return bottomMinutes
    }

    fun getClockText(): String {
        return standardTime.toString()
    }
}




