package com.bcassar.domain.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by bcassar on 27/10/2022
 */

fun String.toDate(): Date {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return simpleDateFormat.parse(this) ?: Date()
}