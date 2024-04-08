package com.debunrebuild.berlinclock

import org.junit.Assert
import org.junit.Test
import java.lang.RuntimeException


class BerlinClockUtilsKtTest {

    @Test(expected = RuntimeException::class)
    fun `if hours is greater than 23 then bottomhours should throw exception`(){
        getBottomHourList(24)
    }
    @Test(expected = RuntimeException::class)
    fun `if hours is less than 0 then bottomhours should throw exception`(){
        getBottomHourList(24)
    }

    @Test
    fun `if hours is 12 then Bottom Hours should be YYOO`() {
        val bottomHours = getBottomHourList(12)
        val string = bottomHours.joinToString(separator = ",") { it.state }
        println(string)
        Assert.assertEquals("Y,Y,O,O",string)
    }
}