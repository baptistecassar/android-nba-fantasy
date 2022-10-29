package com.bcassar.domain.model

/**
 * Created by bcassar on 29/10/2022
 */
enum class GameStatus(val code: Int) {
    FINISHED(3),
    ON_GOING(2),
    PLANNED(1);

    companion object {
        fun fromInt(code: Int): GameStatus {
            return GameStatus.values().find { it.code == code } ?: PLANNED
        }
    }
}