package com.bcassar.nbafantasy.utils

import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toTimeUnit

/**
 * Created by bcassar on 28/10/2022
 */
object DateUtils {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd").apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }
    private const val startNbaSeason = "2022-10-18"
    private const val endNbaSeason = "2023-06-18"

    @OptIn(ExperimentalTime::class)
    fun getSeasonTotalDays(): Int {
        val start = simpleDateFormat.parse(startNbaSeason)
        val end = simpleDateFormat.parse(endNbaSeason)
        val length = end?.time?.minus(start?.time ?: 0) ?: 0
        val days = DurationUnit.MILLISECONDS.toTimeUnit().toDays(length)
        return days.toInt()
    }

    fun getDayDateWithCalendar(dayAfterStart: Int): String {
        val start = simpleDateFormat.parse(startNbaSeason)
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        start?.let {
            calendar.time = start
            calendar.add(Calendar.DATE, dayAfterStart)
        }
        return simpleDateFormat.format(calendar.time)
    }

    @OptIn(ExperimentalTime::class)
    fun getDayAfterSeasonStart(): Int {
        val start = simpleDateFormat.parse(startNbaSeason)
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        val length = calendar.timeInMillis.minus(start?.time ?: 0)
        val days = DurationUnit.MILLISECONDS.toTimeUnit().toDays(length)
        return days.toInt()
    }
}