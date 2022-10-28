package com.bcassar.data.utils

import java.io.InputStreamReader

/**
 * Created by bcassar on 27/10/2022
 */
class MockResponseFileReader(path: String) {

    val content: String

    init {
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
        content = reader.readText()
        reader.close()
    }
}