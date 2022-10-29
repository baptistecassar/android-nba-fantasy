package com.bcassar.nbafantasy

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toTimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun timezone_isCorrect() {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"))
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        assertEquals(15, hour)
    }

    @OptIn(ExperimentalTime::class)
    @Test
    fun calcul_isCorrect() {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val startNbaSeason = "2022-10-18"
        val endNbaSeason = "2023-06-18"
        val start = sdf.parse(startNbaSeason)
        val end = sdf.parse(endNbaSeason)
        val length = end?.time?.minus(start?.time ?: 0) ?: 0
        val days = DurationUnit.MILLISECONDS.toTimeUnit().toDays(length)
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"))
        assert(calendar.time.after(start) && calendar.time.before(end))
    }
}