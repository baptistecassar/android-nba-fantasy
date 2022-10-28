package com.bcassar.nbafantasy.utils

/**
 * Created by bcassar on 27/10/2022
 */
class Event<out T>(val data: T) {

    private var consumed = false

    fun consume(): Event<T>? {
        return if (consumed) {
            null
        } else {
            consumed = true
            this
        }
    }
}