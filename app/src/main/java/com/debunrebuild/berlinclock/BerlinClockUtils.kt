package com.debunrebuild.berlinclock


fun getSecondsState(seconds: Int): LampState {
    if (seconds < 0 || seconds > 59) {
        throw RuntimeException("Invalid number of seconds")
    }
    return if (seconds % 2 == 0) return LampState.ON else LampState.OFF
}


fun getTopHourList(noOfHours: Int): Array<LampState> {
    if (noOfHours < 0 || noOfHours > 23) {
        throw RuntimeException("Invalid number of hours")
    }
    val arrayOfLampState = Array<LampState>(4) { LampState.OFF }
    val noOf5HourLamps = noOfHours / 5
    for (i in 0 until noOf5HourLamps) {
        arrayOfLampState[i] = LampState.ON
    }
    return arrayOfLampState
}

fun getTopMinuteList(noOfMinutes: Int): Array<LampState> {
    if (noOfMinutes < 0 || noOfMinutes > 59) {
        throw RuntimeException("Invalid number of minutes")
    }
    val arrayOfLampState = Array<LampState>(11) { LampState.OFF }
    val noOf11MinuteLamps = noOfMinutes / 5
    for (i in 0 until noOf11MinuteLamps) {
        if ((i + 1) % 3 == 0) {
            arrayOfLampState[i] = LampState.QUARTER_ON
        } else {
            arrayOfLampState[i] = LampState.ON
        }

    }
    return arrayOfLampState
}

fun getBottomMinuteList(noOfMinutes: Int): Array<LampState> {
    if (noOfMinutes < 0 || noOfMinutes > 59) {
        throw RuntimeException("Invalid number of minutes")
    }
    val arrayOfLampState = Array<LampState>(4) { LampState.OFF }
    val noOf11MinuteLamps = noOfMinutes % 5
    for (i in 0 until noOf11MinuteLamps) {
        arrayOfLampState[i] = LampState.ON
    }
    return arrayOfLampState
}


fun getBottomHourList(noOfHours: Int): Array<LampState> {
    if (noOfHours < 0 || noOfHours > 23) {
        throw RuntimeException("Invalid number of hours")
    }
    val arrayOfLampState = Array<LampState>(4) { LampState.OFF }
    val noOf1HourLamps = noOfHours % 5
    for (i in 0 until noOf1HourLamps) {
        arrayOfLampState[i] = LampState.ON
    }
    return arrayOfLampState
}
