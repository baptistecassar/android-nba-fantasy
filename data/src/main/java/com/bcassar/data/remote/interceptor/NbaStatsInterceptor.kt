package com.bcassar.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by bcassar on 27/10/2022
 */
class NbaStatsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder().addHeader("Referer", "https://www.nba.com/").build()
        return chain.proceed(request)
    }
}