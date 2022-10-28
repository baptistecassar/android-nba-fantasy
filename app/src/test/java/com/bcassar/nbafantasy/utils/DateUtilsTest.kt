package com.bcassar.nbafantasy.utils

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by bcassar on 28/10/2022
 */
class DateUtilsTest {
    @Test
    fun `nba season length`() {
        val totalDays = DateUtils.getSeasonTotalDays()
        assertEquals(243, totalDays)
    }

    @Test
    fun `get day after start season`() {
        assertEquals("2022-10-18", DateUtils.getDayDateWithCalendar(0))
        assertEquals("2022-10-30", DateUtils.getDayDateWithCalendar(12))
        assertEquals("2022-11-01", DateUtils.getDayDateWithCalendar(14))
    }
}