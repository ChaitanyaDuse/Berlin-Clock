package com.debunrebuild.berlinclock

import java.util.Calendar


class StandardClock {

    fun setTime(time: Long) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = time
        this.hour = calendar.get(Calendar.HOUR_OF_DAY)
        this.minute = calendar.get(Calendar.MINUTE)
        this.second = calendar.get(Calendar.SECOND)
    }

    var hour = 0
    var minute = 0
    var second = 0

    override fun toString(): String {
        return "$hour : $minute : $second"
    }
}