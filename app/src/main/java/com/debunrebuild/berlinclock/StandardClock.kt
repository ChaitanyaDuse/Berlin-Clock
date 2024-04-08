package com.debunrebuild.berlinclock

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class StandardClock {
    val stringFormat = "hh:mm:ss"
    fun setTime(time: Long) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = time
        timeInMiliSeconds = time
        this.hour = calendar.get(Calendar.HOUR_OF_DAY)
        this.minute = calendar.get(Calendar.MINUTE)
        this.second = calendar.get(Calendar.SECOND)
    }

    var hour = 0
    var minute = 0
    var second = 0
    var timeInMiliSeconds : Long = 0

    override fun toString(): String {
        return SimpleDateFormat(stringFormat, Locale.getDefault(Locale.Category.FORMAT)).format(timeInMiliSeconds)
    }
}