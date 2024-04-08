package com.debunrebuild.berlinclock

import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Test
import java.util.Calendar


class BerlinClockTest{

    @Test
    fun `for time 12 h 09 m 13s clock output should be `() {
        val expectedOutput  = "O : Y,Y,O,O : Y,Y,O,O : Y,O,O,O,O,O,O,O,O,O,O : Y,Y,Y,Y"
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 12)
        calendar.set(Calendar.MINUTE, 9)
        calendar.set(Calendar.SECOND, 13)
        val berlinClock = BerlinClock(calendar.timeInMillis)
        val strb = StringBuffer()
        strb.append(berlinClock.getSeconds().state)
        strb.append(" : ")
        strb.append(berlinClock.getTopHourList().joinToString(","){it.state})
        strb.append(" : ")
        strb.append(berlinClock.getBottomHourList().joinToString(","){it.state})
        strb.append(" : ")
        strb.append(berlinClock.getTopMinuteList().joinToString(","){it.state})
        strb.append(" : ")
        strb.append(berlinClock.getBottomMinuteList().joinToString(","){it.state})
        Assert.assertEquals(expectedOutput, strb.toString())
    }

}